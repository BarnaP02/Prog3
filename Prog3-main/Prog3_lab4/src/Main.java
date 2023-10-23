import java.util.*;
import java.io.*;
public class Main {
    public static List<Beer> sorok = new ArrayList<Beer>();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Beer egyik = new Beer("soproni", "vilagos", 4.5);
        Beer masik = new Beer("dreher", "barna", 4.8);
        System.out.println(egyik.toString());
        System.out.println(masik.toString());

        while(true) {
            String egysor = scanner.nextLine();
            String[] array = egysor.split(" ");
            if (array[0].equals("exit")) {
                break;
            } else if (array[0].equals("add")) {
                add(array);
            } else if (array[0].equals("list")) {
                String key = scanner.nextLine();
                list(key);
            } else if (array[0].equals("save")) {
                Beer.saveBeerList("teszt.txt", sorok);
            }
            else if (array[0].equals("load")) {
                sorok = Beer.loadBeerList("teszt.txt");
            }
            else if (array[0].equals("search")) {
                String key = scanner.nextLine();
                search(key);
            }
            else if (array[0].equals("find")) {
                String key = scanner.nextLine();
                find(key);
            }
            else if (array[0].equals("delete")) {
                String name = scanner.nextLine();
                delete(name);
            }
        }
    }

    protected static void add(String[] cmd) {
        Beer uj = new Beer(cmd[1], cmd[2], Double.parseDouble(cmd[3]));
        sorok.add(uj);
        System.out.println("Uj sor sikeresen hozzaadva");
    }
    protected static void list(String key) {
        Comparator<Beer> comparator = null;

        switch (key) {
            case "name":
                comparator = new NameComparator();
                break;
            case "style":
                comparator = new StyleComparator();
                break;
            case "strength":
                comparator = new StrengthComparator();
                break;
            default:
                System.out.println("Ismeretlen rendezési kulcs: " + key);
                return;
        }

        Collections.sort(sorok, comparator);
        for (Beer beer : sorok) {
            System.out.println(beer);
        }
    }

    protected static void search(String name) {
        for(Beer beer : sorok) {
            if(beer.getName().equals(name)) {
                System.out.println(beer.toString());
            }
        }
    }

    protected static void find(String st) {
        for(Beer beer : sorok) {
            if(beer.getName().contains(st)) {
                System.out.println(beer.toString());
            }
        }
    }

    protected static void delete(String name) {
        for(int i = 0; i < sorok.size(); i++) {
            if(sorok.get(i).getName().equals(name)) {
                sorok.remove(i);
            }
        }
        System.out.println("Sor sikeresen kitorolve");
    }
}