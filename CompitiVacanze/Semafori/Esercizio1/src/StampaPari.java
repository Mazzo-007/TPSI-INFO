import java.util.concurrent.Semaphore;

public class StampaPari extends Thread {
    private Semaphore smPari;
    private Semaphore smDispari;

    public StampaPari (Semaphore smPari, Semaphore smDispari) {
        this.smPari = smPari;
        this.smDispari = smDispari;
    }

    @Override
    public void run() {
        for (int i = 2; i <= 20; i += 2) {
            try {
                smPari.acquire();
            }catch (InterruptedException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
            System.out.println("Pari: " + i);
            smDispari.release();
        }
    }
}
