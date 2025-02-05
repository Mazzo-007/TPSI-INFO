import java.util.ArrayList;

public class Prigione {
    /**
     * ATTRIBUTI
     * */

    private String nome, indirizzo;
    private ArrayList<SistemaMonitoraggio> sistemi;

    /**
     * COSTRUTTORI
     * */

    public Prigione (String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        sistemi = new ArrayList<>();
    }

    /**
     * GET & SET
     * */

    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getIndirizzo () {
        return indirizzo;
    }

    public void setIndirizzo (String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public ArrayList<SistemaMonitoraggio> getSistemi () {
        return sistemi;
    }

    /**
     * AGGIUNGI SISTEMA
     * */

    public void aggiungiSistema (SistemaMonitoraggio sistema) {
        sistemi.add (sistema);
    }

    /**
     * RIMUOVI SISTEMA
     * */

    public void rimuoviSistema (SistemaMonitoraggio sistema) {
        sistemi.remove (sistema);
    }
}
