import java.lang.Thread;
public class Producer extends Thread {
    private final Fifo fifo;
    private final String szoveg;
    //private int szam;
    private final int ido;
    public Producer(Fifo f, String sz, int n, int t) {
        fifo = f;
        szoveg = sz;
        //szam = n;
        ido = t;
    }
    public void go() {
        for(int i = 0; i >= 0; i++) {
            System.out.println(szoveg + " " + i + " " + System.currentTimeMillis()%100000);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run() {
        for(int i = 0; i >= 0; i++) {
            try {
                fifo.put(szoveg + " " + i);
                System.out.println("produced " + szoveg + " " + i + " " + System.currentTimeMillis() % 100000);
                Thread.sleep(ido);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        /*for(int i = 0; i >= 0; i++) {
            System.out.println(szoveg + " " + i + " " + System.currentTimeMillis()%100000);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
    }
}
