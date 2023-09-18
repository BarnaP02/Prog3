import java.util.Random;
public class Asztal {
    private Jatekos[] jatekosok = new Jatekos[0];
    private double tet;
    private int kor;
    Random random = new Random();
    private double goal = random.nextDouble() * 100;

    public void ujJatek(){
        tet = 0;
        kor = 0;
        goal = 100 * random.nextDouble();
    }
    public void addJatekos(Jatekos j){
        if(jatekosok.length>9) {
            System.out.println("Tele van az asztal.");
            return;
        }
            Jatekos[] jtks = new Jatekos[jatekosok.length+1];
            for (int i = 0; i < jatekosok.length; ++i){
                jtks[i] = jatekosok[i];
            }
            jtks[jatekosok.length] = j;
            jatekosok = jtks;
    }
    public int getKor(){
        return kor;
    }
    public void emel(double d){
        tet += d;
    }
    public void kor(){
        kor++;
        Jatekos gyoztes;
        boolean van_gyoztes = false;
        boolean nincs_gyoztes = false;
        for (int i = 0; i < jatekosok.length; ++i){
            jatekosok[i].lep();
            if (tet>=goal){
                System.out.println("Vege a jateknak.");
                if (!van_gyoztes && !nincs_gyoztes && tet<=goal*1.1){
                    gyoztes = jatekosok[i];
                    System.out.println("A gyoztes: " + gyoztes);
                    van_gyoztes=true;
                }
                else{
                    nincs_gyoztes = true;
                    System.out.println("Senki se nyert.");
                }
            }
        }
        System.out.println("tet: " + getTet());

    }
    public double getTet(){
        return tet;
    }

}
