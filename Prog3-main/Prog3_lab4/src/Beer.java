import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Beer implements Serializable {
    private String name;
    private String style;
    private double strength;

    public Beer(String n, String s, double st) {
        name = n;
        style = s;
        strength = st;
    }
    public String getName() {return name;}
    public String getStyle() {return style;}
    public double getStrength() {return strength;}

    @Override
    public String toString() {
        return "Sor: " + name + "\tJelleg: " + style + "\tAlkoholfok: " + strength;
    }

    public static void saveBeerList(String filename, List<Beer> beerList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(beerList);
            System.out.println("Sörlista sikeresen mentve a(z) " + filename + " fájlba.");
        } catch (IOException e) {
            System.err.println("Hiba történt a mentés során: " + e.getMessage());
        }
    }
    public static List<Beer> loadBeerList(String filename) {
        List<Beer> beerList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            beerList = (List<Beer>) ois.readObject();
            System.out.println("Sörlista betöltve a(z) " + filename + " fájlból.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Hiba történt a betöltés során: " + e.getMessage());
        }
        return beerList;
    }
}
