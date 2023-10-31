package main;

import entity.Cruser;
import tile.Tile;
import tile.TileManager;
import unit.SuperUnit;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLSyntaxErrorException;

public class GamePanel  extends JPanel implements Runnable{
    // SCREEN SETTINGS
    final int originalTileHeight = 20;
    final int originalTileWidth = 21;
    final int scale = 2;
    public final int tileHeight = originalTileHeight * scale;
    public final int tileWidth = originalTileWidth * scale;
    public final int maxScreenCol = 21;
    public final int maxScreenRow = 19;
    public final int screenWidth = tileWidth * maxScreenCol + tileWidth/2;
    public final int screenHeight = (tileHeight * (maxScreenRow - 1)) / 4*3 + tileHeight;

    //WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileWidth * maxWorldCol + tileWidth/2;
    public final int worldHeight = (tileHeight * (maxWorldRow - 1)) / 4*3 + tileHeight;

    //FPS
    int FPS = 60;

    public Tile[][] Grid = new Tile[maxWorldCol][maxWorldRow];
    public int[][] neighborOffsetEven = {                              //Offset in even rows
            {0, -1}, {-1, 0}, {0, 1}, {1, 1}, {1, 0}, {1, -1}
    };
    public int[][] neighborOffsetOdd = {                              //Offset in odd rows
            {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 0}, {0, -1}
    };
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public AssetSetter aSetter = new AssetSetter(this);
    public Cruser cruser = new Cruser(this, keyH);
    public SuperUnit army[] = new SuperUnit[100];        //mennyi egyseg lehet a kepen


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){
        aSetter.setUnit();
    }
    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;


        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS:" + drawCount);
                //System.out.println("x:" + cursorX + " y:" + cursorY);
                drawCount = 0;
                timer = 0;

                //DEBUG PRINTF
                /*for (int i = 0; i < maxScreenRow;++i){
                    for (int j = 0; j < maxScreenCol;++j){
                        System.out.print(Grid[j][i].numOfBorder()+Grid[j][i].getType()+" ");
                    }
                    System.out.print("..........");
                    for (int j = 0; j < maxScreenCol;++j) {
                        for (int m = 0; m < 6; ++m){
                            if (Grid[j][i].getBorder(m)!=null){
                                System.out.print(Grid[j][i].getBorder(m).getCoords()[0]+","+Grid[j][i].getBorder(m).getCoords()[1]+" ");
                            }
                            System.out.print(" | ");
                        }
                        System.out.print("/|/ ");
                    }
                    System.out.println();
                }
                System.out.println();*/
                for (int i = 0; i < 6; ++i){
                    System.out.print(cruser.getHover().borders()[i]+" ");
                }
                System.out.print("["+cruser.getHover().getCoords()[0]+":"+cruser.getHover().getCoords()[1]+"]  ["+
                        cruser.getLast_hover().getCoords()[0]+":"+cruser.getLast_hover().getCoords()[1]+"]  [" +
                        cruser.getScreenX()+":"+cruser.getScreenY()+"]  s:"+cruser.isNotNearScreenEdge()+" e:"+cruser.isNotNearEdge()+"  t:"+
                        cruser.nearTopEdge()+" b:"+cruser.nearBotEdge()+" l:"+cruser.nearLeftEdge()+" r:"+cruser.nearRightEdge()+"  st:"+
                        cruser.nearScreenTop()+" sb:"+cruser.nearScreenBot()+" sl:"+cruser.nearScreenLeft()+" sr:"+cruser.nearScreenRight()+" ");
                System.out.println();
            }
        }
    }
    public void update() {
        cruser.update();
    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);
        cruser.draw(g2);
        for (SuperUnit superUnit : army) {
            if (superUnit != null) {
                superUnit.draw(g2, this);
            }
        }

        g2.dispose();
    }
    public Tile getTilefromWorldCoords(int searchedWorldX, int searchedWorldY){
        int worldCol = 0;
        int worldRow = 0;
        while (worldCol < maxWorldCol && worldRow < maxWorldRow){

            //int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = tileWidth * worldCol + tileWidth/2;
            int worldY = (tileHeight * (worldRow - 1)) / 4*3 + tileHeight;
            if (worldX==searchedWorldX && worldY==searchedWorldY) { return Grid[worldCol][worldRow]; }
            worldCol++;
            if (worldCol == maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
        return null;
    }
}
