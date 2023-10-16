import java.util.Iterator;

public class List implements Command{
    @Override
    public void execute(String[] cmd){
        if(!cmd[0].equals("list")) { return; }
        Iterator<Integer> iterator = Main.verem.iterator();
        System.out.print("Verem tartalma: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
