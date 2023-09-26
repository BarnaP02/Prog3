import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        File wd = new File(System.getProperty("user.dir"));
        Scanner scanner = new Scanner(System.in);

        boolean exit_not_called = true;
        while (exit_not_called){
            String line;
            line = scanner.nextLine();
            String cmd[] = line.split(" ");
            if (cmd[0].equals("exit")) { exit_not_called = false; }
            else if (cmd[0].equals("pwd")){ pwd(wd); }
            else if (cmd[0].equals("ls")){ ls(wd, cmd); }
            else if (cmd[0].equals("cd")){ wd = cd(wd, cmd); }
        }
    }
    public static void pwd(File wd){
        System.out.println(wd);
        System.out.println(wd.listFiles().length + " db fajl van benne.");
    }
    public static void ls(File wd, String[] cmd){
        if(wd.listFiles().length==0) {
            System.out.println("The folder is empty.");
            return;
        }
        if (cmd.length>1){
        	if(cmd[1].equals("-l")){
        		String[] contents = wd.list();
        		for( int i = 0; i < wd.listFiles().length; ++i){
        			File current  = new File(wd, contents[i]);
        			String[] name = wd.list()[i].split(".");
        			String type = "";
        			
        			int index = wd.list()[i].lastIndexOf(".");
        			if (index>0){
        				type = "f";
        			}
        			else{
        				type = "d";
        			}
        			//if(name.length<1) { type = "d " + name[0];}
        			//else { type = "f"; }
        			System.out.println(contents[i] + " " + current.length() + " byte " + type);
        		}
        	}
        }
        else{
        	String[] contents = wd.list();
        	for (int i = 0; i < wd.listFiles().length; ++i){
            	System.out.println(contents[i]);
        	}
        }
    }
    public static File cd(File wd, String[] cmd){
        if (cmd[1]=="..") { return wd.getParentFile(); }
        File inner = new File(wd, cmd[1]);
        return inner;
    }
}