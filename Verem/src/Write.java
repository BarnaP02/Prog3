public class Write implements Command{
    @Override
    public void execute(String[] cmd){
        if(!cmd[0].equals("write")) { return; }
        System.out.println(Main.verem.pop());
    }
}
