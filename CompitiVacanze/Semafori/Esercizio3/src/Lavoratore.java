import java.util.concurrent.Semaphore;

public class Lavoratore extends Thread {
    private String name;
    private Semaphore s;

    public Lavoratore (String name, Semaphore s) {
        this.name = name;
        this.s = s;
    }

    @Override
    public void run () {
        while (true) {
            try {
                s.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Il lavoratore " + name + " sta lavorando");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Il lavoratore " + name + " ha finito di lavorare");
            s.release();
        }
    }
}
