
public class Robot extends Jatekos{

	private int id = 0;
	public Robot(){
		id++;
	}
	public void lep(){
        System.out.println("Robot neve: " + toString() + " kor: " + asztal.getKor());
	}
	public String toString(){
		return "Robot" + id;
	}
}
