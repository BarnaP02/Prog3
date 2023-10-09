import java.util.Date;

public class Producer implements Runnable{
    private String szoveg;
    private Fifo queue;
    private int producing_time;
    public Producer(String s, Fifo f, int n){
        szoveg = s;
        queue = f;
        producing_time = n;
    }

    public void run(){
        int count = 0;
        boolean exit = false;
        while(!exit){
            try {
                queue.put(szoveg + " " + count);
                String ido = getTime();
                System.out.println("produced " + szoveg + " " + count++ + " " + ido);
                Thread.sleep(producing_time);
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
