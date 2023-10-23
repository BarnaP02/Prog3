public class Read implements Command {
    public void execute (String[] cmd) {
        Main.stack.push(Main.sc.nextInt());
    }
}
