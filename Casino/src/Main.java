
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        Asztal asztal = new Asztal();
        Asztal asztal1 = new Asztal();
        Jatekos Pityu = new Kezdo("Pityu");
        Jatekos Peti = new Kezdo("Peti");
        Jatekos Petra = new Robot();
        Jatekos Meseter = new Mester(10);
        Jatekos Nyul= new Nyuszi("kek");
        Pityu.setAsztal(asztal);
        Peti.setAsztal(asztal);
        Petra.setAsztal(asztal);
        asztal.addJatekos(Pityu);
        asztal.addJatekos(Peti);
        asztal.addJatekos(Petra);
        Nyul.setAsztal(asztal1);
        Meseter.setAsztal(asztal1);
        try{
        	asztal.ujJatek();
        	asztal.kor();
        	asztal.kor();
        	asztal.kor();
        	System.out.println();
        	System.out.println();
        	System.out.println();
        	asztal1.ujJatek();
        	asztal1.kor();
        	
        } catch (Exception hiba){
        	System.out.println("Hiba tortent: " + hiba);
        }
        try{

        	asztal1.addJatekos(Nyul);
        	asztal1.addJatekos(Meseter);
        	for(int i = 0; i < 10; ++i){
        		asztal1.kor();
        	}
        	
        } catch (Exception hiba){
        	System.out.println("Hiba tortent: " + hiba);
        }
    }
}