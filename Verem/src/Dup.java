public class Dup implements Command{
    @Override
    public void execute(String[] cmd){
        if(!cmd[0].equals("dup")) { return; }
        try{
            Integer copied = Verem.stack.peek();
            Main.verem.push(copied);
        } catch (NullPointerException e) {
            System.out.println("The Verem is empty.");
        }
    }
}
