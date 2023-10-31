package unit;

import javax.imageio.ImageIO;
import java.io.IOException;

public class U_infantry_L extends SuperUnit{
    public U_infantry_L(){
        name = "infantryL";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/units/infantryL.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
