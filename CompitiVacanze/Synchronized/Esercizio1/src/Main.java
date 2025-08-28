public class Main {
    public static void main(String[] args) {
        int capacita = 5;
        int numProduttori = 7;
        int sogliaX = 250;

        Magazzino magazzino = new Magazzino(capacita, numProduttori);

        for (int i = 0; i < numProduttori; i++) {
            new Produttore(magazzino).start();
        }

        new Consumatore(magazzino).start();
        new Ispettore(magazzino, sogliaX).start();
    }
}