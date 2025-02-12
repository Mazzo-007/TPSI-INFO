package RivenditaVeicoli;

public abstract class Veicolo {
    //------------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------ATTRIBUTI------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    private String marca, modello;
    private int anno;

    //------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------METODI-------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    //COSTRUTTORE
    public Veicolo(String marca, String modello, int anno) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
    }

    //GET & SET
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    //DESCRIVI
    public abstract String descrivi();

    //TO STRING
    @Override
    public String toString() {
        return "Veicolo{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", anno=" + anno +
                '}';
    }
}
