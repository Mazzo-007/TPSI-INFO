package priorityManager;

import arrayQueue.ArrayQueue;

public class coda <T> extends ArrayQueue <T> {
    //ATTRIBUTI

    private String nomeCoda;

    //METODI

    //COSTRUTTORE
    public coda (String nomeCoda) {
        this.nomeCoda = nomeCoda;
    }

    //GET & SET
    public String getNomeCoda() {
        return nomeCoda;
    }

    public void setNomeCoda(String nomeCoda) {
        this.nomeCoda = nomeCoda;
    }

    //TO STRING
    @Override
    public String toString() {
        String r = "Coda per pazienti: " + nomeCoda + "Pazienti:";

        for (int i = 0; i < super.size(); i++) {

        }

        return r;
    }
}
