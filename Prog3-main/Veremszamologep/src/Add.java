public class Add implements Command {
    public void execute (String[] cmd) {
        Main.stack.push(Main.stack.pop() + Main.stack.pop());
    }
}
