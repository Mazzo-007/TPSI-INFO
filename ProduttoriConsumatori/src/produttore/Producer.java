package produttore;

import risorsa.SharedResource;

public class Producer extends Thread {
    private SharedResource sharedResource;
    private final int MAX_ITERATION = 20;

    public Producer (SharedResource sharedResource) {
        //super("Producer");
        setName("Producer");
        this.sharedResource = sharedResource;
    }

    @Override
    public void run () {
        // per 20 volte genera un numero casuale e mettilo nella risorsa
        for (int i = 0; i < MAX_ITERATION; i++) {
            int val = (int) (Math.random()*(100-1)) + 1;
            try {
                Thread.sleep(0);
                sharedResource.addValue(val);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto.");
            }
        }
    }
}
