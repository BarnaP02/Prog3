public class Sub implements Command{
    @Override
    public void execute(String[] cmd){
        if(!cmd[0].equals("sub")) { return; }
        try{
            Integer top = Main.verem.pop();
            Integer bot = Main.verem.pop();
            Integer res = top - bot;
            Main.verem.push(res);
        } catch (NullPointerException e) {
            System.out.println("The Verem is empty.");
        }
    }
}
