package consumatore;

import risorsa.SharedResource;

public class Consumer extends Thread {
    private SharedResource sharedResource;
    private final int MAX_ITERATION = 20;

    public Consumer(SharedResource sharedResource) {
        setName("Consumer");
        this.sharedResource = sharedResource;
    }

    public void run () {
        // per 20 volte preleva il primo elemento della risorsa
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(0);
                sharedResource.getValue();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrotto.");
            }
        }
    }

}
