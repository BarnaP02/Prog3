public class Read implements Command{
    @Override
    public void execute(String[] cmd){
        if(!cmd[0].equals("read")) { return; }
        Main.verem.push(Integer.parseInt(String.valueOf(Main.scanner.next().charAt(0))));
    }
}
