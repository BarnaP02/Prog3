import java.util.Date;

public class Consumer extends Thread{
    private int n;
    private String szoveg;
    private Fifo queue;

    public Consumer(String s, Fifo f, int n){
        szoveg = s;
        queue = f;
        this.n = n;
    }
    public void run(){
        boolean exit = false;
        while(!exit){
            try {
                String olvasott = queue.get();
                String ido = getTime();
                System.out.println("consumed " + szoveg + " " + olvasott + " " + ido);
                Thread.sleep(n);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
    private String getTime() {
        long currentDate = new Date().getTime();
        String dateString = String.valueOf(currentDate);
        int length = dateString.length();
        return dateString.substring(length - 5);
    }
}