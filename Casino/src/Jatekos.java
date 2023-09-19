
public abstract class Jatekos {
    protected Asztal asztal;
    public void lep(){
        System.out.println("kor: " + asztal.getKor() + ", tet: " + asztal.getTet());
    }
    public void setAsztal(Asztal a){
        asztal = a;
    }
}