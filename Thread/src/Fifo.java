
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
        //System.out.println("put " + Thread.currentThread().getName());
        notifyAll();
    }
    public synchronized String get() throws InterruptedException {
        while(lista.isEmpty()){
            wait();
        }
        String item = lista.removeFirst();
        //System.out.println("get " + Thread.currentThread().getName());
        notifyAll();
        return item;
    }
}