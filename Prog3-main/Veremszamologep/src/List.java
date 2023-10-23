import java.util.Iterator;

public class List implements Command {
    public void execute (String[] cmd) {
        for (Integer integer : Main.stack) {
            System.out.println(integer);
        }
    }
}
