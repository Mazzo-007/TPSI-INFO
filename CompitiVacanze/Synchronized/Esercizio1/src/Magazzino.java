import java.util.ArrayList;

public class Magazzino {
    private final int capacita;
    private ArrayList<Integer> buffer = new ArrayList<>();
    private boolean ispettoreDentro;

    public Magazzino (int capacita, int produttori) {
        if (produttori <= capacita)
            throw new IllegalArgumentException("Il numero di produttori non è maggiore della capacità max");
        this.capacita = capacita;
    }

    public synchronized void add (int element) throws InterruptedException {
        while (ispettoreDentro || buffer.size() == capacita) {
            wait();
        }
        buffer.add(element);
        System.out.println("Produttore ha inserito: " + element + " | Magazzino: " + buffer);
        notifyAll();
    }

    public synchronized int get () throws InterruptedException {
        while (ispettoreDentro || buffer.isEmpty()) {
            wait();
        }
        int val = buffer.removeLast();
        System.out.println("Consumatore ha consumato: " + val + " | Magazzino: " + buffer);
        notifyAll();
        return val;
    }

    public synchronized void entraIspettore (int  X) {
        ispettoreDentro = true;
        int somma = 0;

        for (int i : buffer) {
            somma += i;
        }

        if (somma >= X) {
            System.out.println("[ISPETTORE] Somma >= " + X + " (" + somma + ") -> Reset magazzino");
            buffer.clear();
        } else {
            System.out.println("[ISPETTORE] Somma attuale = " + somma + " -> Inserisco in prima posizione");
            buffer.set(0, somma);
        }

        ispettoreDentro = false;
        notifyAll();
    }
}
