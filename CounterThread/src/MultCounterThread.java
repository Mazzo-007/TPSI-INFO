import java.util.concurrent.Semaphore;

public class MultCounterThread extends Thread {
    private Counter c;
    private static final Semaphore sem = new Semaphore(1);

    public MultCounterThread (Counter c) {
        this.c = c;
    }

    @Override
    public void run () {
        for (int i = 0; i < 10; i++) {
            try {
                sem.acquire();
            }catch (InterruptedException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
            c.mult(2);
            sem.release();
        }
    }
}
