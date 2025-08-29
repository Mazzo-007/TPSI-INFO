import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Spogliatoio spogliatoio = new Spogliatoio();
        Pista pista = new Pista();
        ArrayList<Giocatore> listaGiocatori = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            listaGiocatori.add(new Giocatore(Integer.toString(i), spogliatoio, pista));
        }

        for (Giocatore g : listaGiocatori) {
            g.start();
        }

        for (Giocatore g : listaGiocatori) {
            g.join();
        }

        System.out.println("---------------------------------");
        System.out.println("CLASSIFICA");
        System.out.println(pista.stampaClassifica());
    }
}