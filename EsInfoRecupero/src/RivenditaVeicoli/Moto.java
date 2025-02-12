package RivenditaVeicoli;

public class Moto extends Veicolo {
    //------------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------ATTRIBUTI------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    private boolean sideCar;

    //------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------METODI-------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    //COSTRUTTORE
    public Moto(String marca, String modello, int anno, boolean sideCar) {
        super(marca, modello, anno);
        this.sideCar = sideCar;
    }

    //GET & SET
    public boolean getSideCar() {
        return sideCar;
    }

    public void setSideCar(boolean sideCar) {
        this.sideCar = sideCar;
    }

    //DESCRIVI
    @Override
    public String descrivi() {
        return "Moto" +
                super.toString().substring(7, super.toString().length() - 1) +
                ", sideCar=" + sideCar +
                '}';
    }
}
