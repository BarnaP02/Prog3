
public class Kezdo extends Jatekos{
	private String nev;
	public Kezdo(String n){
		nev=n;
	}
	public void lep(){
        System.out.println("kor: " + asztal.getKor() + ", tet: " + asztal.getTet());
		if(asztal.getKor()%2!=1){
			asztal.emel(1.0);
		}
	}
	public String toString(){
		return nev;
	}
	
}
