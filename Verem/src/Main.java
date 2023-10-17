import java.util.*;

public class Main {
    public static Verem verem = new Verem();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<String, Command> map = new HashMap<>();
        Command c = new Exit();
        map.put("exit", c);
        c = new List();
        map.put("list", c);
        c = new Push();
        map.put("push", c);
        c = new Pop();
        map.put("pop", c);
        c = new Dup();
        map.put("dup", c);
        c = new Read();
        map.put("read", c);
        c = new Write();
        map.put("write", c);
        c = new Add();
        map.put("add", c);
        c = new Sub();
        map.put("sub", c);
        c = new Mult();
        map.put("mult", c);
        c = new Div();
        map.put("div", c);

        //boolean exit_not_called = true;
        while (true) {
            String line;
            line = scanner.nextLine();
            String[] cmd = line.split(" ");
            Command com = map.get(cmd[0]);
            com.execute(cmd);
            //if (cmd[0].equals("exit")) { exit_not_called = false; }
        }
    }
}