import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore s = new Semaphore(3);

        ArrayList<Lavoratore> listaLavoratori = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            listaLavoratori.add(new Lavoratore(Integer.toString(i) ,s));
        }

        for (int i = 0; i < 10; i++) {
            listaLavoratori.get(i).start();
        }
    }
}