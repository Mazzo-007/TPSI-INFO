import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore smPari = new Semaphore(0);
        Semaphore smDispari = new Semaphore(1);

        StampaPari sp = new StampaPari(smPari, smDispari);
        StampaDispari sd = new StampaDispari(smPari, smDispari);

        sp.start();
        sd.start();
    }
}