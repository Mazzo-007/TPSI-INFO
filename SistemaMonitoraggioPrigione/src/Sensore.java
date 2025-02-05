public abstract class Sensore {
    /**
     * ATTRIBUTI
     * */

    private int ID, stato;

    /**
     * COSTRUTTORI
     * */

    public Sensore (int ID, int stato) {
        this.ID = ID;
        this.stato = stato;
    }

    /**
     * GET & SET
     * */

    public int getID () {
        return ID;
    }

    public void setID (int ID) {
        this.ID = ID;
    }

    public int getStato () {
        return stato;
    }

    public void setStato (int stato) {
        this.stato = stato;
    }

    /**
     * METODI ASTRATTI
     * */

    public abstract void eseguiDiagnostica ();
    public abstract void accendi ();
    public abstract void spegni ();
}
