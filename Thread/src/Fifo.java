
import java.util.LinkedList;

public class Fifo {
    private LinkedList<String> lista;
    private int len;
    public Fifo(int l){
        lista = new LinkedList<String>();
        len = l;
    }
    public synchronized void put(String item) throws InterruptedException {
        while(lista.size() == len) {
            wait();
        }
        lista.add(item);
        notifyAll();
    }
    public synchronized String get() throws InterruptedException {
        while(lista.isEmpty()){
            wait();
        }
        String item = lista.removeFirst();
        notifyAll();
        return item;
    }
}
