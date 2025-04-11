package rubrica;

public class Contatto {
    //ATTRIBUTI

    private String nome, numero;

    //METODI

    //COSTRUTTORE
    public Contatto(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    //GET & SET
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    //TO STRING
    @Override
    public String toString() {
        return  nome + ", numero: " + numero;
    }
}
