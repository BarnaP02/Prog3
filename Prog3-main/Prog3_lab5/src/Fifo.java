import java.util.LinkedList;
public class Fifo {
    private LinkedList<String> storage = new LinkedList<>();
    private int maxsize = 10;
    public synchronized void put(String string) throws InterruptedException {
        while(storage.size() >= maxsize) {
            wait();
        }
        storage.add(string);
        notifyAll();
    }

    public synchronized String get() throws InterruptedException {
        while(storage.isEmpty()) {
            wait();
        }
        String first = storage.removeFirst();
        notifyAll();
        return first;
    }
}
