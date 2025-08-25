import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Barriera b = new Barriera(5);
        ArrayList<Lavoratore> listaLavoratori = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            listaLavoratori.add(new Lavoratore(Integer.toString(i), b));
        }

        for (int i = 0; i < 5; i++) {
            listaLavoratori.get(i).start();
        }
    }
}