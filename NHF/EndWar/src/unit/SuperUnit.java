package unit;

import main.GamePanel;
import tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperUnit {
    public BufferedImage image;
    public String name;
    public int worldX, worldY;
    public Tile currentTile;

    public void draw(Graphics2D g2, GamePanel gp){

        int screenX;
        int screenY;

        screenX = worldX - gp.cruser.worldX + gp.cruser.screenX - gp.tileWidth/2;
        screenY = worldY - gp.cruser.worldY + gp.cruser.screenY - gp.tileHeight/4;
        if (currentTile.getCoords()[1] % 2 == 0) {
            screenX += gp.tileWidth/2;
        }
        if (screenX > - gp.tileWidth &&
                screenX <  gp.screenWidth + gp.tileWidth &&
                screenY > - gp.tileHeight &&
                screenY < gp.screenHeight + gp.tileHeight){
            g2.drawImage(image, screenX, screenY, gp.tileWidth, gp.tileHeight, null);
            //gp.Grid[worldCol][worldRow].isOnScreen = true;
        }
        //else gp.Grid[worldCol][worldRow].isOnScreen = false;
    }
    public void setCurrentTile(GamePanel gp, int x, int y){
        currentTile = gp.Grid[x-1][y-1];
    }
}
