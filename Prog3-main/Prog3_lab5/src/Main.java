import java.lang.Thread;
public class Main {
    public static void main(String[] args) {
        Fifo fifo = new Fifo();
        Producer pro1 = new Producer(fifo, "pro", 1, 3000);
        //Producer pro2 = new Producer (fifo, "masodikpro", 2, 2000);
        Consumer con1 = new Consumer(fifo, "con", 2000);
        pro1.start();
        /*try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        pro2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        con1.start();
    }
}