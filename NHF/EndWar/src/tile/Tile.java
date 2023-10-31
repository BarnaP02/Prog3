package tile;

import java.awt.image.BufferedImage;

public class Tile {
    public BufferedImage image;
    String type;
    int coords[];
    Tile border[];
    int borders[];
    boolean isStructure;
    boolean isStructureDoor;
    boolean isRoad;
    boolean isSelected;
    boolean isHighlighted;
    boolean isOnScreen;
    Tile(){
        image = null;
        type = null;
        coords = new int[2];
        border = new Tile[6];
        borders = new int[6];
        isStructure = false;
        isStructureDoor = false;
        isRoad = false;
        isSelected = false;
        isHighlighted = false;
    }
    public void setBorder(int i, Tile t){
        border[i] = t;
    }

    public Tile getBorder(int i) {
        return border[i];
    }

    public int[] getCoords() {
        return coords;
    }

    public int numOfBorder(){
        int counter = 0;
        for(Tile b : border){
            if(b != null) counter++;
        }
        return counter;
    }

    public int[] borders(){
        int counter = 0;
        for(int i = 0; i < 6; i++){
            if(border[i] != null) borders[i]=1;
            else borders[i]=0;
        }
        return borders;
    }

    public String getType() {
        return type;
    }
}
