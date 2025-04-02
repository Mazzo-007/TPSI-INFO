package registroElettronico;

public class Voto {
    //ATTRIBUTI
    private String data;
    private char tipo;
    private double valore;

    //METODI
    //COSTRUTTORE
    public Voto (String data, int tipo, double valore) {
        this.data = data;
        this.valore = valore;

        switch (tipo) {
            case 1 -> this.tipo = 'S';
            case 2 -> this.tipo = 'O';
            case 3 -> this.tipo = 'P';
        }
    }

    //TO STRING
    @Override
    public String toString() {
        return "Voto{" +
                "data='" + data + '\'' +
                ", tipo=" + tipo +
                ", valore=" + valore +
                '}';
    }
}
