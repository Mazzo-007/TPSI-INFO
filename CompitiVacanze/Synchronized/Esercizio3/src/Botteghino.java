public class Botteghino {
    private int bigliettiDisponibili = 100;
    private int personeAlBotteghino = 0;

    // Metodo per comprare il biglietto
    public synchronized boolean compraBiglietto (String nome) throws InterruptedException {
        while (personeAlBotteghino >= 5) {
            wait();
        }

        if (bigliettiDisponibili <= 0) {
            return false;
        }

        personeAlBotteghino++;
        System.out.println(nome + " è al botteghino. Persone attuali: " + personeAlBotteghino);

        Thread.sleep((int)(Math.random() * 2000) + 500);

        if (bigliettiDisponibili > 0) {
            bigliettiDisponibili--;
            System.out.println(nome + " ha comprato un biglietto! Biglietti rimasti: " + bigliettiDisponibili);
        } else {
            System.out.println(nome + " non ha trovato più biglietti disponibili.");
        }

        personeAlBotteghino--;
        notifyAll();
        return true;
    }
}
