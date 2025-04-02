package registroElettronico;

import java.util.ArrayList;

public class Studente {
    //ATTRIBUTI
    private Anagrafica anagrafica;
    private ArrayList<Voto> listaVoti;

    //METODI
    //COSTRUTTORE
    public Studente (String nome, String cognome, String telefono, String email, String matricola) {
        anagrafica = new Anagrafica(nome, cognome, telefono, email, matricola);
        listaVoti = new ArrayList<>();
    }

    //GET & SET
    public Anagrafica getAnagrafica() {
        return anagrafica;
    }

    public void setAnagrafica(Anagrafica anagrafica) {
        this.anagrafica = anagrafica;
    }

    //AGGIUNGI VOTO
    public void aggiungiVoto (Voto v) {
        listaVoti.add(v);
    }

    //TO STRING
    @Override
    public String toString() {
        String r = "Studente:\n" + anagrafica + ",";
        for (Voto v : listaVoti) {
            r += "\n  " + v;
        }
        return r;
    }
}
