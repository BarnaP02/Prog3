package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp){
        this.gp = gp;

        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/maps/map021.txt");
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass2.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/concrete2.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water2v2.png"));
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/structure.png"));
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/structure_door.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private boolean isValidHexagon(int col, int row) {
        return row >= 0 && row < gp.maxWorldRow && col >= 0 && col < gp.maxWorldCol;
    }

    public void loadMap(String filePath){
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();

                while (col < gp.maxWorldCol) {
                    String pure[] = line.split(",");
                    String numbers[] = pure[1].split("-");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    gp.Grid[col][row] = new Tile();
                    gp.Grid[col][row].coords[0] = col;
                    gp.Grid[col][row].coords[1] = row;
                    gp.Grid[col][row].type = numbers[col];
                    ++col;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    ++row;
                }
            }
            for (int r = 0; r < gp.maxWorldRow; ++r) {
                for (int c = 0; c < gp.maxWorldCol;++c) {
                    for (int i = 0; i < 6; i++) {
                        int newCol;         //[0,0]nál amikor i = 3 akkor látnia kéne az 1,1et de valamiért nem látja
                        int newRow;
                        if (r % 2 == 0) {
                            newCol = c + gp.neighborOffsetEven[i][0];
                            newRow = r + gp.neighborOffsetEven[i][1];
                        } else {
                            newCol = c + gp.neighborOffsetOdd[i][0];
                            newRow = r + gp.neighborOffsetOdd[i][1];
                        }
                        if (isValidHexagon(newCol, newRow)) {
                            gp.Grid[c][r].setBorder(i, gp.Grid[newCol][newRow]);
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;
        //int x = gp.tileWidth/2;
        //int y  =0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = gp.tileWidth * worldCol + gp.tileWidth/2;
            int worldY = (gp.tileHeight * (worldRow - 1)) / 4*3 + gp.tileHeight;
            int screenX;
            int screenY;
            screenX = worldX - gp.cruser.worldX + gp.cruser.screenX - gp.tileWidth/2;
            screenY = worldY - gp.cruser.worldY + gp.cruser.screenY - gp.tileHeight/4;
            if (worldRow % 2 == 0) {
                screenX += gp.tileWidth/2;
            }
            if (screenX > - gp.tileWidth &&
                    screenX <  gp.screenWidth + gp.tileWidth &&
                    screenY > - gp.tileHeight &&
                    screenY < gp.screenHeight + gp.tileHeight){
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileWidth, gp.tileHeight, null);
                gp.Grid[worldCol][worldRow].isOnScreen = true;
            }
            else gp.Grid[worldCol][worldRow].isOnScreen = false;
            worldCol++;
            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
