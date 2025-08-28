public class Produttore extends Thread {
    private Magazzino m;
    private int prodotto;

    public Produttore (Magazzino m) {
        this.m = m;
    }

    @Override
    public void run () {
        while (true) {
            do {
                prodotto = (int) (Math.random() * (99));
            } while (prodotto % 2 == 1);
            try {
                m.add(prodotto);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
