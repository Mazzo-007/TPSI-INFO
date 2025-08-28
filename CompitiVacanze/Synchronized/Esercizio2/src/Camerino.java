import java.util.concurrent.Semaphore;

public class Camerino {
    private final int capacita;
    private Semaphore posti;

    public Camerino (int capacita) {
        this.capacita = capacita;
        this.posti = new Semaphore(capacita);
    }

    public void entra (String nome) throws InterruptedException {
        int wait;
        posti.acquire();
        stampaSicura(nome + " è entrato nel camerino. Posti liberi: " + posti.availablePermits());
        wait = (int)(Math.random()*(6000-2000))+2000;
        Thread.sleep(wait);
        stampaSicura(nome + " ci ha messo " + (wait/1000) + " secondi a cambiarsi");
    }

    public void esce (String nome) {
        posti.release();
        stampaSicura(nome + " è uscito dal camerino. Posti liberi: " + posti.availablePermits());
    }

    private void stampaSicura(String messaggio) {
        synchronized(System.out) {
            System.out.println(messaggio);
        }
    }
}
