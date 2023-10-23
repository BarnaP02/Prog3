import java.util.*;
import java.io.*;
public class Main {
    public static List<Beer> sorok = new ArrayList<Beer>();
    public static Scanner scanner = new Scanner(System.in);
    public static Map<String, Comparator<Beer>> comps = new HashMap<>();
    public static HashMap<String, Command> commands =  new HashMap<>();
    public static void main(String[] args) {
        Beer egyik = new Beer("soproni", "vilagos", 4.5);
        Beer masik = new Beer("dreher", "barna", 4.8);
        System.out.println(egyik.toString());
        System.out.println(masik.toString());
        Comparator<Beer> namecomp = Comparator.comparing(Beer::getName);
        Comparator<Beer> stylecomp = Comparator.comparing(Beer::getStyle);
        Comparator<Beer> strengthcomp = Comparator.comparing(Beer::getStrength);
        comps.put("name", namecomp);
        comps.put("style", stylecomp);
        comps.put("strength", strengthcomp);
        commands.put("exit", Main::exit);
        commands.put("add", Main::add);
        commands.put("list", Main::list);
        commands.put("save", Beer::saveBeerList);
        commands.put("load", Beer::loadBeerList);
        commands.put("search", Main::search);
        commands.put("find", Main::find);
        commands.put("delete", Main::delete);
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] cmd = line.split(" ");
            if(!commands.containsKey(cmd[0])) {
                System.out.println("Nincs ilyen parancs");
                continue;
            }
            commands.get(cmd[0]).execute(cmd);
        }
    }

    private static void exit(String[] cmd) {
        System.exit(0);
    }
    protected static void add(String[] cmd) {
        Beer uj = new Beer(cmd[1], cmd[2], Double.parseDouble(cmd[3]));
        sorok.add(uj);
        System.out.println("Uj sor sikeresen hozzaadva");
    }
    protected static void list(String[] key) {
        Comparator<Beer> cmp = comps.get(key[1]);
        if(comps.containsKey(key[1])) {
            sorok.sort(cmp);
            for (Beer beer : sorok) {
                System.out.println(beer);
            }
        }
        else {
            System.out.println("Nincs ilyen rendezesi mod");
        }
    }

    protected static void search(String[] name) {
        for(Beer beer : sorok) {
            if(beer.getName().equals(name[1])) {
                System.out.println(beer.toString());
            }
        }
    }

    protected static void find(String[] st) {
        for(Beer beer : sorok) {
            if(beer.getName().contains(st[1])) {
                System.out.println(beer.toString());
            }
        }
    }

    protected static void delete(String[] name) {
        for(int i = 0; i < sorok.size(); i++) {
            if(sorok.get(i).getName().equals(name[1])) {
                sorok.remove(i);
            }
        }
        System.out.println("Sor sikeresen kitorolve");
    }
}