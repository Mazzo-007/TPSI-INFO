public class SistemaTemperatura extends SistemaMonitoraggio {
    /**
     * COSTRUTTORI
     * */

    public SistemaTemperatura (int ID, String nome) {
        super(ID, nome);
    }

    /**
     * CALCOLO STATISTICHE
     * */

    @Override
    public void calcoloStatistiche () {
        System.out.println ("Statistiche sistema di monitoraggio temperatura {");
        System.out.println ("  ID -> " + super.getID ());
        System.out.println ("  Nome -> " + super.getNome ());
        System.out.println ("  Numero di sensori -> " + super.getSensori().size());
        System.out.println ("}");
    }
}
