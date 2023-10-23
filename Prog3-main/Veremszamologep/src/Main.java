import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static ArrayDeque<Integer> stack = new ArrayDeque<>();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        HashMap<String, Command> map = new HashMap<>();
        map.put("exit", new Exit());
        map.put("list", new List());
        map.put("push", new Push());
        map.put("pop", new Pop());
        map.put("dup", new Dup());
        map.put("read", new Read());
        map.put("write", new Write());
        map.put("add", new Add());
        map.put("sub", new Sub());
        map.put("mult", new Mult());
        map.put("div", new Div());
        while(sc.hasNext()) {
            String line = sc.nextLine();
            String[] cmd = line.split(" ");
            Command c = map.get(cmd[0]);
            c.execute(cmd);
        }
    }
}