
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        Asztal asztal = new Asztal();
        Jatekos Pityu = new Jatekos();
        Jatekos Peti = new Jatekos();
        Jatekos Petra = new Jatekos();
        Pityu.setAsztal(asztal);
        Peti.setAsztal(asztal);
        Petra.setAsztal(asztal);
        asztal.addJatekos(Pityu);
        asztal.addJatekos(Peti);
        asztal.addJatekos(Petra);

        asztal.ujJatek();
        asztal.kor();
        asztal.kor();
        asztal.kor();
    }
}