import java.util.concurrent.Semaphore;

public class Buffer {
    private int[] buffer;
    private int tail;
    private int head;

    private Semaphore vuoti;
    private Semaphore pieni;
    private Semaphore mutex;

    public Buffer (int size) {
        buffer = new int[size];
        tail = 0;
        head = 0;

        vuoti = new Semaphore(size);
        pieni = new Semaphore(0);
        mutex = new Semaphore(1);
    }

    public void put (int element) {
        try {
            vuoti.acquire();
            mutex.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        buffer[tail] = element;
        tail++;
        if (tail == (buffer.length-1)) tail = 0;
        mutex.release();
        pieni.release();
    }

    public int get () {
        try {
            pieni.acquire();
            mutex.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int element;
        element = buffer[head];
        buffer[head] = 0;
        head++;
        if (head == (buffer.length-1)) head = 0;
        mutex.release();
        vuoti.release();
        return element;
    }
}
