import java.util.*;
import java.io.*;
import java.util.Iterator;

public class Main {
    public static ArrayList<Beer> lista = new ArrayList<Beer>();
    public static Scanner scanner = new Scanner(System.in);
    public static Map<String, Comparator<Beer>> comps = new HashMap<>();
    public static HashMap<String, Command> commands =  new HashMap<>();
    public static LinkedList<String> lparams = new LinkedList<String>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ArrayList<Beer> lista= new ArrayList<Beer>();

        Beer sor1 = new Beer("citronyos", "nem csapolt", 1.2);
        Beer sor2 = new Beer("csodalkozo", "csapolt", 0.0);
        System.out.println(sor1.toString());
        System.out.println(sor2.toString());
        Comparator<Beer> namecomp = Comparator.comparing(Beer::getName);
        Comparator<Beer> stylecomp = Comparator.comparing(Beer::getStyle);
        Comparator<Beer> strengthcomp = Comparator.comparing(Beer::getAlkoholfok);
        comps.put("name", namecomp);
        comps.put("style", stylecomp);
        comps.put("strength", strengthcomp);
        commands.put("exit", Main::exit);
        commands.put("add", Main::add);
        commands.put("list", Main::list);
        commands.put("save", Main::save);
        commands.put("load", Main::load);
        commands.put("search", Main::search);
        commands.put("find", Main::find);
        commands.put("delete", Main::delete);
        for(String key : comps.keySet()){
        	lparams.add(key);
        }

        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] cmd = line.split(" ");
            if(!commands.containsKey(cmd[0])) {
                System.out.println("Nincs ilyen parancs");
                continue;
            }
            commands.get(cmd[0]).execute(cmd);
        }
        /*
        boolean exit_not_called = true;
        while (exit_not_called) {
            String line;
            line = scanner.nextLine();
            String[] cmd = line.split(" ");
            if (cmd[0].equals("exit")) { exit(); }
            else if (cmd[0].equals("add")){ add(cmd, lista); }
            else if (cmd[0].equals("list")){ list(lista, cmd); }
            else if (cmd[0].equals("load")){ load(lista, cmd[1]); }
            else if (cmd[0].equals("save")){ save(lista, cmd[1]); }
            else if (cmd[0].equals("search")){ search(lista, cmd); }
            else if (cmd[0].equals("find")){ find(lista, cmd); }
            else if (cmd[0].equals("delete")){ delete(lista, cmd[1]); }
        }*/
    }
    protected static void exit(String[] cmd){
        System.exit(0);
    }
    protected static void add(String[] cmd){
        Beer uj = new Beer(cmd[1], cmd[2], Double.parseDouble(cmd[3]));
        lista.add(uj);

        System.out.println(uj.toString() + " bele kerult.");
    }
    protected static void list(String[] cmd){
        if(cmd.length==0){ return; }
        if(cmd.length==1){
            for (Beer listaelem : lista){
                System.out.println(listaelem.toString());
            }
        }
        else{
            if (cmd[1].equals("name")){
            	/*Collections.sort(lista,
            		(b1,b2) -> b1.getName().compareTo(b2.getName())
            		);*/
    	        for(String key : lparams){
    	        	System.out.println("ooo " + key);
    	        }
            	for(int i = 0; i < lparams.size(); ++i){
            		if(cmd[1].equals(lparams.get(i))){
            			lparams.add(lparams.remove(i));

            	        for(String key : lparams){
            	        	System.out.println(key);
            	        }
            	        break;
            		}
            	}/*
                //comps.get(cmd[0]).compare(cmd);
            	for(String elem : lparams){
            		Collections.sort(lista, comps.get(elem));
            	}
                //Collections.sort(lista, new NameComparator());
                for (Beer listaelem : lista){
                    System.out.println(listaelem.toString());
                }*/
            }
            if (cmd[1].equals("style")){
            	/*Collections.sort(lista,
            			(b1,b2) -> b1.getStyle().compareTo(b2.getStyle())
            			);*/
    	        for(String key : lparams){
    	        	System.out.println("--- " + key);
    	        }
            	for(int i = 0; i < lparams.size(); ++i){
            		if(cmd[1].equals(lparams.get(i))){
            			lparams.add(lparams.remove(i));

            	        for(String key : lparams){
            	        	System.out.println(key);
            	        }
            	        break;
            		}
            	}/*
                //comps.get(cmd[0]).compare(cmd);
            	for(String elem : lparams){
            		Collections.sort(lista, comps.get(elem));
            	}
            	//Collections.sort(lista, new StyleComparator());
                for (Beer listaelem : lista){
                    System.out.println(listaelem.toString());
                }*/
            }
            if (cmd[1].equals("strength")){
            	/*Collections.sort(lista,
            			(b1,b2) -> Double.compare(b1.getAlkoholfok(), b2.getAlkoholfok())
            			);*/
    	        for(String key : lparams){
    	        	System.out.println("/// " + key);
    	        }
            	for(int i = 0; i < lparams.size(); ++i){
            		if(cmd[1].equals(lparams.get(i))){
            			lparams.add(lparams.remove(i));

            	        for(String key : lparams){
            	        	System.out.println(key);
            	        }
            	        break;
            		}
            	}
            }
            //comps.get(cmd[0]).compare(cmd);
        	for(String elem : lparams){
        		Collections.sort(lista, comps.get(elem));
        	}
            //Collections.sort(lista, new StrengthComparator());
            for (Beer listaelem : lista){
                System.out.println(listaelem.toString());
            }
        }
    }
    protected static void load(String[] cm){
        try (BufferedReader reader = new BufferedReader(new FileReader("beerlist.txt"))) {
            // Write content to the file
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cmd = line.split(" ");
                Beer uj = new Beer(cmd[0], cmd[1], Double.parseDouble(cmd[2]));
                lista.add(uj);
            }

            System.out.println("Content has been loaded from the file.");

        } catch (IOException e) {
            if (e instanceof java.io.FileNotFoundException) {
                // Handle the case where the file or directory doesn't exist
                System.err.println("The specified directory doesn't exist or is inaccessible.");
            } else {
                e.printStackTrace();
                // Handle other IOExceptions
            }
        }
    }
    protected static void save(String[] cmd){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("beerlist.txt"))) {
            // Write content to the file
            for( Beer listaelem : lista){
                writer.write(listaelem.getName() + " " + listaelem.getStyle() + " " + listaelem.getAlkoholfok());
                writer.newLine();
            }

            System.out.println("Content has been written to the file.");

        } catch (IOException e) {
            if (e instanceof java.io.FileNotFoundException) {
                // Handle the case where the file or directory doesn't exist
                System.err.println("The specified directory doesn't exist or is inaccessible.");
            } else {
                e.printStackTrace();
                // Handle other IOExceptions
            }
        }
    }
    protected static void search(String[] cmd){
        if(cmd.length==2){
            for (Beer listaelem : lista){
                if(listaelem.getName().equals(cmd[1]))
                    System.out.println(listaelem.toString());
            }
        }
        else {
            for (Beer listaelem : lista) {
                if (cmd[1].equals("name")) {
                    if (listaelem.getName().equals(cmd[2]))
                        System.out.println(listaelem.toString());
                }
                if (cmd[1].equals("style")) {
                    if (listaelem.getStyle().equals(cmd[2]))
                        System.out.println(listaelem.toString());
                }
                if (cmd[1].equals("strength")) {
                    if (listaelem.getAlkoholfok() == Double.parseDouble(cmd[2]))
                        System.out.println(listaelem.toString());
                }
            }
        }
    }
    protected static void find(String[] cmd){
        if(cmd.length==2){
            for (Beer listaelem : lista){
                if(listaelem.getName().contains(cmd[1]))
                    System.out.println(listaelem.toString());
            }
        }
        else{
            for (Beer listaelem : lista){
                if(cmd[1].equals("name")){
                    if(listaelem.getName().contains(cmd[2]))
                        System.out.println(listaelem.toString());
                }
                if(cmd[1].equals("style")){
                    if(listaelem.getStyle().contains(cmd[2]))
                        System.out.println(listaelem.toString());
                }
                if(cmd[1].equals("strength")){
                    if(listaelem.getAlkoholfok() >= Double.parseDouble(cmd[2]))
                        System.out.println(listaelem.toString());
                }
                if(cmd[1].equals("weaker")){
                    if(listaelem.getAlkoholfok() <= Double.parseDouble(cmd[2]))
                        System.out.println(listaelem.toString());
                }
            }
        }
    }
    protected static void delete(String[] cmd){
        Iterator<Beer> it = lista.iterator();
        while(it.hasNext()) {
          Beer i = it.next();
          if(i.getName().equals(cmd[1])) {
            it.remove();
            System.out.println("The item has been deleted.");
          }
        }
    }
}