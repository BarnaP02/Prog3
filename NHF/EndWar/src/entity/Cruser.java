package entity;

import main.GamePanel;
import main.KeyHandler;
import tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Cruser extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    boolean fromLeft;
    Tile hover;
    Tile last_hover;
    public int screenX;
    public int screenY;

    public Cruser(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        fromLeft = false;
        hover = gp.Grid[0][0];
        last_hover = gp.Grid[0][0];

        screenX = gp.tileWidth/2;
        screenY = 0;

        setDefaultValues();
        getCruserImage();
    }
    public void setDefaultValues() {
        worldX = gp.tileWidth/2;
        worldY = 0;
        isVisible = true;
        direction = "right";
    }
    public void getCruserImage() {
        try {
            sprite1 = ImageIO.read(getClass().getResourceAsStream("/cruser/sprite1.png"));
            sprite2 = ImageIO.read(getClass().getResourceAsStream("/cruser/sprite2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update(){
        slowCounter++;
        if (slowCounter!=slowNum) { return; }
        slowCounter = 0;
        if (keyH.upPressed && (hover.getBorder(0)!=null || hover.getBorder(5) != null)) {
            worldY -= gp.tileHeight/4*3;
            if(fromLeft) {
                worldX += gp.tileWidth / 2;
                fromLeft = false;
                direction = "l-up";
                last_hover = hover;
                //hover = hover.getBorder(0);
            } else {
                worldX -= gp.tileWidth / 2;
                fromLeft = true;
                direction = "r-up";
                last_hover = hover;
                //hover = hover.getBorder(5);
            }
            hover = gp.Grid[hover.getCoords()[0]][hover.getCoords()[1]-1];
            if(fromLeft) {
                screenX -= gp.tileWidth / 2;
            }
            else {
                screenX += gp.tileWidth / 2;
            }
            if (!nearScreenTop() || nearTopEdge()) {      //ha nincs közel a palya szelehez akkor o mozog, egyebkent a palya
                screenY -= gp.tileHeight/4*3;
            }
        }
        if (keyH.downPressed && (hover.getBorder(2)!=null || hover.getBorder(3) != null)) {
            worldY += gp.tileHeight/4*3;
            if(fromLeft) {
                worldX += gp.tileWidth / 2;
                fromLeft = false;
                direction = "l-down";
                last_hover = hover;
                //hover = hover.getBorder(2);
            } else {
                worldX -= gp.tileWidth / 2;
                fromLeft = true;
                direction = "r-down";
                last_hover = hover;
                //hover = hover.getBorder(3);
            }
            hover = gp.Grid[hover.getCoords()[0]][hover.getCoords()[1]+1];
            if(fromLeft) {
                screenX -= gp.tileWidth / 2;
            }
            else {
                screenX += gp.tileWidth / 2;
            }
            if (!nearScreenBot() || nearBotEdge()) {      //ha nincs közel a palya szelehez akkor o mozog, egyebkent a palya
                screenY += gp.tileHeight/4*3;
            }
        }
        if (keyH.leftPressed && hover.getBorder(1)!=null) {
            worldX -= gp.tileWidth;
            direction = "left";
            last_hover = hover;
            //hover = hover.getBorder(1);
            hover = gp.Grid[hover.getCoords()[0]-1][hover.getCoords()[1]];
            if (!nearScreenLeft() || nearLeftEdge()){      //ha nincs közel a palya szelehez akkor o mozog, egyebkent a palya
                screenX -= gp.tileWidth;
            }
        }
        if (keyH.rightPressed && hover.getBorder(4)!=null) {
            worldX += gp.tileWidth;
            direction = "right";
            last_hover = hover;
            //hover = hover.getBorder(4);
            hover = gp.Grid[hover.getCoords()[0]+1][hover.getCoords()[1]];
            if (!nearScreenRight() || nearRightEdge()){      //ha nincs közel a palya szelehez akkor o mozog, egyebkent a palya
                screenX += gp.tileWidth;
            }
        }
        if (keyH.spacePressed) {
            //x += gp.tileWidth;
            direction = "vilagur";
        }
    }
    public void draw(Graphics2D g2){

        BufferedImage image = null;

        switch (direction) {
            case "l-up":
                image = sprite1;
                break;
            case "r-up":
                image = sprite1;
                break;
            case "l-down":
                image = sprite1;
                break;
            case "r-down":
                image = sprite1;
                break;
            case "left":
                image = sprite1;
                break;
            case "right":
                image = sprite1;
                break;
            case "vilagur":
                image = sprite2;
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileWidth, gp.tileHeight, null);
    }

    public void setHover(Tile hover) {
        this.hover = hover;
    }

    public Tile getHover() {
        return hover;
    }

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public Tile getLast_hover() {
        return last_hover;
    }

    public boolean isNotNearScreenEdge() {
        return screenY >= (3*gp.tileHeight/4*3+gp.tileHeight)
                && screenY < ((gp.maxScreenRow-3)*gp.tileHeight/4*3+gp.tileHeight)
                && screenX >= (3*gp.tileWidth)
                && screenX < ((gp.maxScreenCol-3)*gp.tileWidth);
    }
    public boolean nearScreenLeft() {
        return screenX < (3*gp.tileWidth);
    }
    public boolean nearScreenRight() {
        return screenX >= ((gp.maxScreenCol-3)*gp.tileWidth);
    }
    public boolean nearScreenTop() {
        return screenY < (3*gp.tileHeight/4*3);//+gp.tileHeight);
    }
    public boolean nearScreenBot() {
        return screenY >= ((gp.maxScreenRow-3)*gp.tileHeight/4*3);// - gp.tileHeight);
    }
    public boolean isNotNearEdge() {
        return worldY >= (3*gp.tileHeight/4*3 + gp.tileHeight)
                && worldY < (gp.worldHeight - (3*gp.tileHeight/4*3))
                && worldX >= (3*gp.tileWidth)
                && worldX < (gp.worldWidth - 3*gp.tileWidth);
    }
    public boolean nearLeftEdge() {
        return worldX < ((3-1)*gp.tileWidth);
    }
    public boolean nearRightEdge() {
        return worldX >= (gp.worldWidth - 2.5*gp.tileWidth);
    }
    public boolean nearTopEdge() {
        return worldY < ((3-1)*gp.tileHeight/4*3);// - gp.tileHeight;
    }
    public boolean nearBotEdge() {
        return worldY >= (gp.worldHeight - (3*gp.tileHeight/4*3));// - gp.tileHeight);
    }
}
