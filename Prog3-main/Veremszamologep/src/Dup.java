public class Dup implements Command {
    public void execute (String[] cmd) {
        assert Main.stack.peek() != null;
        Main.stack.push(Main.stack.peek());
    }
}
