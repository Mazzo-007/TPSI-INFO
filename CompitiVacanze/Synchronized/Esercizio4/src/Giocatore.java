public class Giocatore extends Thread {
    private String nome;
    private Spogliatoio spogliatoio;
    private Pista pista;
    private int tempoGiro, tempoTot;

    public Giocatore(String nome, Spogliatoio spogliatoio, Pista pista) {
        this.nome = nome;
        this.spogliatoio = spogliatoio;
        this.pista = pista;
        tempoGiro = 0;
        tempoTot = 0;
    }

    @Override
    public void run () {
        try {
            spogliatoio.entra(nome);
            System.out.println(nome + " si sta cambiando");
            Thread.sleep((int)(Math.random() * (4000 - 2000) + 2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        spogliatoio.esci(nome);

        System.out.println(nome + " è salito sul kart");

        try {
            pista.entra(nome);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 1; i < 3; i++) {
            System.out.println(nome + " inizia il giro numero " + i);
            tempoGiro = pista.giro();
            tempoTot += tempoGiro;
            try {
                Thread.sleep(tempoGiro);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        pista.esci(nome);

        System.out.println(nome + " ha girato in: " + tempoTot + " secondi");

        try {
            spogliatoio.entra(nome);
            System.out.println(nome + " si sta cambiando per uscire");
            Thread.sleep((int)(Math.random() * (4000 - 2000) + 2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        spogliatoio.esci(nome);

        pista.aggiornaClassifica(tempoTot, nome);
    }
}
