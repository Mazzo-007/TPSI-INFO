import com.sun.security.jgss.GSSUtil;

import java.util.concurrent.Semaphore;

public class counterThread extends Thread {
    private Counter c;
    private static final Semaphore sem = new Semaphore(1);

    public counterThread (Counter c) {
        this.c = c;
    }

    @Override
    public void run () {
        for (int i = 0; i < 10000; i++) {
            try {
                sem.acquire();
            }catch (InterruptedException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
            c.add(1);
            sem.release();
        }
    }
}
