import java.util.concurrent.Semaphore;

public class Passerella {
    private final int capacita;
    private Semaphore posti;

    public Passerella (int capacita) {
        this.capacita = capacita;
        this.posti = new Semaphore(capacita);
    }

    public void sfila (String nome) throws InterruptedException {
        int wait;
        posti.acquire();
        stampaSicura(nome + " sta sfilando. Posti liberi: " + posti.availablePermits());
        wait = (int)(Math.random()*(6000-2000))+2000;
        Thread.sleep(wait);
        stampaSicura(nome + " ci ha messo " + (wait/1000) + " secondi a sfilare");
        posti.release();
        stampaSicura(nome + " è uscito dalla passerella. Posti liberi: " + posti.availablePermits());
    }

    private void stampaSicura(String messaggio) {
        synchronized(System.out) {
            System.out.println(messaggio);
        }
    }
}
