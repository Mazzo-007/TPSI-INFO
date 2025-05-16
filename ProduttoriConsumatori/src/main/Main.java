package main;

import consumatore.Consumer;
import produttore.Producer;
import risorsa.SharedResource;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource(10);
        Producer p = new Producer(sharedResource);
        Consumer c = new Consumer(sharedResource);

        p.start();
        c.start();

        // tutti i metodi di attesa sollevano InterruptedException
        p.join();
        c.join();

        System.out.println("==END==");
    }
}