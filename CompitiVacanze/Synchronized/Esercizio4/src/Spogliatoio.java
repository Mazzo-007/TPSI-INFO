public class Spogliatoio {
    private int postiDisponibili = 2;

    public synchronized void entra (String nome) throws InterruptedException {
        while (postiDisponibili == 0) {
            wait();
        }
        postiDisponibili--;
        System.out.println("Il giocatore: " + nome + " è entrato nello spogliatoio");
    }

    public synchronized void esci (String nome) {
        System.out.println("Il giocatore: " + nome + " è uscito dallo spogliatoio");
        postiDisponibili++;
        notifyAll();
    }
}
