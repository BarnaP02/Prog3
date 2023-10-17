public class Div implements Command{
    @Override
    public void execute(String[] cmd){
        if(!cmd[0].equals("div")) { return; }
        try{
            Integer top = Main.verem.pop();
            Integer bot = Main.verem.peek();
            if(bot == 0) {
            	System.out.println("Nullával most nem osztunk.");
            	Main.verem.push(top);
            	return;
            }
            	bot = Main.verem.pop();
            	Integer res = top / bot;
            	Main.verem.push(res);
            	
            
        } catch (NullPointerException e) {
            System.out.println("The Verem is empty.");
        }
    }
}
