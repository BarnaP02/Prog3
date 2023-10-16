public class Exit implements Command{
    @Override
    public void execute(String[] cmd){
        if(!cmd[0].equals("exit")) { return; }
        System.exit(0);
    }
}
