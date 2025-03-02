package torreHanoi;

public class Disco {
    //ATTRIBUTI
    private int dimensione;

    //METODI

    //COSTRUTTORI
    public Disco(int dimensione) {
        this.dimensione = dimensione;
    }

    //GET & SET
    public int getDimensione() {
        return dimensione;
    }

    public void setDimensione(int dimensione) {
        this.dimensione = dimensione;
    }

    //TO STRING
    @Override
    public String toString() {
        String r = "";

        for (int i = 0; i < dimensione; i++) {
            r += "-";
        }

        return r;
    }
}
