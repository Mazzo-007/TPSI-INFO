
public class Main {
    public static void main(String[] args) {
        Buffer b = new Buffer(10);
        Consumatore c = new Consumatore(b);
        Produttore p = new Produttore(b);

        p.start();
        c.start();
    }
}