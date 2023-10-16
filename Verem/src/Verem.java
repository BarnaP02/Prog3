import java.util.ArrayDeque;
import java.util.Iterator;

public class Verem {//extends ArrayDeque<Integer>{
    public static ArrayDeque<Integer> stack = new ArrayDeque<>();

    void push(Integer d){
        stack.push(d);
    }
    Integer pop(){
        return stack.pop();
    }
    Integer peek(){
        return stack.peek();
    }

    Iterator<Integer> iterator(){
        return stack.iterator();
    }
    int size(){
        return stack.size();
    }
    boolean isEmpty(){
        return stack.isEmpty();
    }
}
