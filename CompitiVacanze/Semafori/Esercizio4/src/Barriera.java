import java.util.concurrent.Semaphore;

public class Barriera {
    private int contatoreMax;
    private int contatore;
    private Semaphore counter;
    private Semaphore rilascio;

    public Barriera(int contatoreMax) {
        this.contatoreMax = contatoreMax;
        contatore = 0;
        counter = new Semaphore(1);
        rilascio = new Semaphore(0);
    }

    public void aspetto () throws InterruptedException {
        counter.acquire();
        contatore++;

        if (contatore == contatoreMax) {
            for (int i = 0; i < contatoreMax; i++) {
                rilascio.release();
            }
        }

        counter.release();
        rilascio.acquire();
    }
}
