public class Pop implements Command{
    @Override
    public void execute(String[] cmd){
        if(!cmd[0].equals("pop")) { return; }
        try{
            Main.verem.pop();
        } catch (NullPointerException e) {
            System.out.println("The Verem is empty.");
        }
    }
}
