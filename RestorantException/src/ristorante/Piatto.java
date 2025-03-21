package ristorante;

public class Piatto {
    //ATTRIBUTI

    private String nome;
    private int nIngredienti;
    private long tempoPreparazione;

    //METODI

    //COSTRUTTORE
    public Piatto(String nome, int nIngredienti, long tempoPreparazione) {
        this.nome = nome;
        this.nIngredienti = nIngredienti;
        this.tempoPreparazione = tempoPreparazione;
    }

    //GET & SET
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getnIngredienti() {
        return nIngredienti;
    }

    public void setnIngredienti(int nIngredienti) {
        this.nIngredienti = nIngredienti;
    }

    public long getTempoPreparazione() {
        return tempoPreparazione;
    }

    public void setTempoPreparazione(long tempoPreparazione) {
        this.tempoPreparazione = tempoPreparazione;
    }

    //TO STRING
    @Override
    public String toString() {
        return "Piatto{" +
                "nome='" + nome + '\'' +
                ", nIngredienti=" + nIngredienti +
                ", tempoPreparazione=" + tempoPreparazione +
                '}';
    }
}
