package entity;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Entity {
    public int worldX,worldY;
    boolean isVisible;

    public BufferedImage sprite1;
    public BufferedImage sprite2;
    public String direction;
    public int slowCounter = 0;
    public int slowNum = 6;
    public int spriteCounter = 0;
    public int spriteNum = 1;
}
