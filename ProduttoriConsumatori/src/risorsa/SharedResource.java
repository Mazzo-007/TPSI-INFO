package risorsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SharedResource {
    private List<Integer> buffer;
    private final int maxLength;

    public SharedResource () {
        this.buffer = new ArrayList<>();
        this.maxLength = 10;
    }

    public SharedResource (int capacity) {
        this.buffer = new ArrayList<>();
        this.maxLength = capacity;
    }

    // chiamato solo da produttore
    public synchronized void addValue (int val) throws InterruptedException {
        while (buffer.size() == maxLength) {
            System.out.println(Thread.currentThread().getName() + " aspetta. (" + buffer.size() + ")");
            wait();
        }
        buffer.add(val);
        System.out.println(Thread.currentThread().getName() + " ha inserito " + val + " (length " + buffer.size() + ")" );
        notifyAll();
    }

    // chiamato solo da consumatore
    public synchronized void getValue () throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + " aspetta. (" + buffer.size() + ")");
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " ha prelevato " + buffer.remove(0) + " (length " + buffer.size() + ")");
        notifyAll();
    }
}
