public class Modello extends Thread {
    private String nome;
    private Camerino camerino;
    private Passerella passerella;

    public Modello (String nome, Camerino camerino, Passerella passerella) {
        this.nome = nome;
        this.camerino = camerino;
        this.passerella = passerella;
    }

    @Override
    public void run () {
        try {
            camerino.entra(nome);
            passerella.sfila(nome);
            camerino.esce(nome);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
