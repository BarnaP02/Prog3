public class Push implements Command {
    public void execute (String[] cmd) {
        Main.stack.push(Integer.valueOf(cmd[1]));
    }
}
