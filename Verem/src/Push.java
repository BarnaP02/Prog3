public class Push implements Command{
    @Override
    public void execute(String[] cmd){
        if(!cmd[0].equals("push")) { return; }
        Main.verem.push(Integer.parseInt(cmd[1]));
    }
}
