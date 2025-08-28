public class Ispettore extends Thread {
    private Magazzino m;
    private int X;

    public Ispettore(Magazzino m, int x) {
        this.m = m;
        X = x;
    }

    @Override
    public void run () {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            m.entraIspettore(X);
        }
    }
}
