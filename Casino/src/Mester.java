
public class Mester extends Jatekos{

	private int mester_fokozat;
	public Mester(int f){
		mester_fokozat = f;
	}
	public void lep(){
        System.out.println(toString() + "kor: " + asztal.getKor());
        asztal.emel(asztal.getTet()*mester_fokozat/100);
	}
	public String toString(){
		return "Mester fokozata: " + mester_fokozat;
	}
}
