public class Consumatore extends Thread {
    private Buffer b;

    public Consumatore (Buffer b) {
        this.b = b;
    }

    @Override
    public void run () {
        while (true) {
            int element = b.get();
            System.out.println(Thread.currentThread().getName() + " preleva: " + (element == 0 ? "null" : element));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
