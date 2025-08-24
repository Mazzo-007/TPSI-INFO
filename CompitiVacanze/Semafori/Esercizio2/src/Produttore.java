public class Produttore extends Thread {
    private Buffer b;

    public Produttore (Buffer b) {
        this.b = b;
    }

    @Override
    public void run () {
        while (true) {
            int element = (int) (Math.random() * (50 - 1 + 1)) + 1;
            b.put(element);
            System.out.println(Thread.currentThread().getName() + " inserisci: " + element);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
