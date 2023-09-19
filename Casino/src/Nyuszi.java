
public class Nyuszi extends Jatekos{

	private String szin;
	public Nyuszi(String n){
		szin=n;
	}
	public void lep(){
        System.out.println("Nyuszi szine: " + toString() + "kor: " + asztal.getKor());
		if(asztal.getTet()<50){
			asztal.emel(5.0);
		}
		else{
			System.out.println("tet erteke: " + asztal.getTet() + " Húha!");
		}
	}
	public String toString(){
		return szin;
	}
}
