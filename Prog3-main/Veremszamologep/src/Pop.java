public class Pop implements Command {
    public void execute (String[] cmd) {
        if(Main.stack.isEmpty()) {
            System.out.println("A verem ures");
            return;
        }
        Main.stack.pop();
    }
}
