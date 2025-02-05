public class SensoreTemperatura extends Sensore {
    /**
     * COSTRUTTORI
     * */

    public SensoreTemperatura (int ID, int stato) {
        super(ID, stato);
    }

    /**
     * ESEGUI DIAGNOSTICA
     * */

    @Override
    public void eseguiDiagnostica () {
        System.out.println ("Diagnostica sensore di temperatura {");
        System.out.println ("  ID -> " + super.getID ());
        System.out.println ("  Stato -> " + super.getStato ());
        System.out.println ("  Diagnostica -> Completata a buon fine");
        System.out.println ("}");
    }

    /**
     * ACCENDI
     * */

    @Override
    public void accendi () {
        super.setStato (1);
    }

    /**
     * SPEGNI
     * */

    @Override
    public void spegni () {
        super.setStato (0);
    }
}
