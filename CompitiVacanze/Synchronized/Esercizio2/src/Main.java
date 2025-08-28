import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Camerino c = new Camerino(6);
        Passerella p = new Passerella(3);
        ArrayList<Modello> modelli = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            modelli.add(new Modello(Integer.toString(i), c, p));
        }

        for (Modello m : modelli) {
            m.start();
        }
    }
}