import java.util.ArrayList;

public class Pista {
    private int postiDisponibili = 4;
    private ArrayList<Integer> classifica = new ArrayList<>();

    public Pista () {
        for (int i = 0; i < 8; i++) {
            classifica.add(-1);
        }
    }

    public synchronized void entra (String nome) throws InterruptedException {
        while (postiDisponibili == 0) {
            wait();
        }
        postiDisponibili--;
        System.out.println("Il giocatore: " + nome + " è entrato nella pista");
    }

    public synchronized void esci (String nome) {
        System.out.println("Il giocatore: " + nome + " è uscito dalla pista");
        postiDisponibili++;
        notifyAll();
    }

    public synchronized int giro () {
        return (int)(Math.random() * (8000 - 5000) + 5000);
    }

    public synchronized void aggiornaClassifica (int tempo, String nome) {
        classifica.add(Integer.parseInt(nome), tempo);
    }

    public String stampaClassifica () {
        String s = "";

        for (int i = 0; i < 8; i++) {
            s += "Il giocatore " + i + " ha girato in: " + classifica.get(i) + " secondi";
            s += "\n";
        }

        return s;
    }
}
