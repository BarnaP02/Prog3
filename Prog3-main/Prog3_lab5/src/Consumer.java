import java.lang.Thread;
public class Consumer extends Thread {
    private final Fifo fifo;
    private final String szoveg2;
    private final int ido;
    public Consumer(Fifo f, String sz, int t) {
        fifo = f;
        szoveg2 = sz;
        ido = t;
    }

    @Override
    public void run() {
        try {
            while(true) {
                String something = fifo.get();
                System.out.println("consumed " + szoveg2 + " " + something + " " + System.currentTimeMillis()%100000);
                Thread.sleep(ido);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
