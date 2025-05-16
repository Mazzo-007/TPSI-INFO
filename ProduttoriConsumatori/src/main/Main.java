package main;

import consumatore.Consumer;
import produttore.Producer;
import risorsa.SharedResource;

import java.util.ArrayList;

public class Main {
    public static final int MAX_CONS = 10;
    public static final int MAX_PROD = 10;
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource(10);
        ArrayList<Producer> producers = new ArrayList<>();
        ArrayList<Consumer> consumers = new ArrayList<>();

        for (int i = 0; i < MAX_CONS; i++) {
            consumers.add(new Consumer(sharedResource));
        }

        for (int i = 0; i < MAX_PROD; i++) {
            producers.add(new Producer(sharedResource));
        }

        // tutti i metodi di attesa sollevano InterruptedException

        for (Consumer c : consumers) {
            c.start();
        }

        for (Producer p : producers) {
            p.start();
        }

        for (Consumer c : consumers) {
            c.join();
        }

        for (Producer p : producers) {
            p.join();
        }

        System.out.println("==END==");
    }
}