package RivenditaVeicoli;

public class Auto extends Veicolo {
    //------------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------ATTRIBUTI------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    private int numeroPorte;

    //------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------METODI-------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    //COSTRUTTORE
    public Auto(String marca, String modello, int anno, int numeroPorte) {
        super(marca, modello, anno);
        this.numeroPorte = numeroPorte;
    }

    //GET & SET
    public int getNumeroPorte() {
        return numeroPorte;
    }

    public void setNumeroPorte(int numeroPorte) {
        this.numeroPorte = numeroPorte;
    }

    //DESCRIVI
    @Override
    public String descrivi() {
        return "Auto" +
                super.toString().substring(7, super.toString().length() - 1) +
                ", numeroPorte=" + numeroPorte +
                '}';
    }
}
