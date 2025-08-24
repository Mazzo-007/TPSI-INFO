import java.util.concurrent.Semaphore;

public class StampaDispari extends Thread {
    private Semaphore smPari;
    private Semaphore smDispari;

    public StampaDispari (Semaphore smPari, Semaphore smDispari) {
        this.smPari = smPari;
        this.smDispari = smDispari;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i += 2) {
            try {
                smDispari.acquire();
            }catch (InterruptedException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
            System.out.println("Dispari: " + i);
            smPari.release();
        }
    }
}
