public class Consumatore extends Thread {
    private Magazzino m;

    public Consumatore (Magazzino m) {
        this.m = m;
    }

    @Override
    public void run () {
        while (true) {
            try {
                m.get();
                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
