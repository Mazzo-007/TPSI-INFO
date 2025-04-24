package rubrica.contatto;

public class Numero {
    //ATTRIBUTI

    private String numero, tipo;

    //METODI

    //COSTRUTTORE
    public Numero (String numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    //GET & SET
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //TO STRING
    @Override
    public String toString() {
        return tipo + ": " + numero;
    }

}
