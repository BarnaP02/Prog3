
public class Application {
    public static void main(String[] args) {

        Fifo queue = new Fifo(10);
        Producer p1 = new Producer("p1", queue, 1000);
        Thread p1_t = new Thread(p1);
        Producer p2 = new Producer("p2", queue, 1000);
        Thread p2_t = new Thread(p2);
        Producer p3 = new Producer("p3", queue, 1000);
        Thread p3_t = new Thread(p3);
        
        
        /*if(!randi){
            Consumer c1 = new Consumer("c1", queue, 100);
            //Thread c1_t = new Thread(c1);
            Consumer c2 = new Consumer("c2", queue, 100);
            //Thread c2_t = new Thread(c2);
            Consumer c3 = new Consumer("c3", queue, 100);
            //Thread c3_t = new Thread(c3);
            Consumer c4 = new Consumer("c4", queue, 100);
            //Thread c4_t = new Thread(c4);        	
        }
        else{*/
            Consumer c1 = new Consumer("c1", queue, (int)(Math.random() * 500));
            //Thread c1_t = new Thread(c1);
            Consumer c2 = new Consumer("c2", queue, (int)(Math.random() * 500));
            //Thread c2_t = new Thread(c2);
            Consumer c3 = new Consumer("c3", queue, (int)(Math.random() * 500));
            //Thread c3_t = new Thread(c3);
            Consumer c4 = new Consumer("c4", queue, (int)(Math.random() * 500));
            //Thread c3_t = new Thread(c4);
        	
        //}

        p1_t.start();
        p2_t.start();
        p3_t.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        c1.start();
        //c1_t.start();
        c2.start();
        //c2_t.start();
        c3.start();
        //c3_t.start();
        c4.start();
        //c4_t.start();
    }
}
