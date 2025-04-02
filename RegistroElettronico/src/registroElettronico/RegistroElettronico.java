package registroElettronico;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RegistroElettronico {
    //ATTRIBUTI
    private Map<String, Studente> registro;

    //METODI
    //COSTRUTTORE
    public RegistroElettronico () {
        registro = new HashMap<>();
    }

    //AGGIUNGI STUDENTE
    public boolean aggiungiStudente (Studente studente) {
        return registro.putIfAbsent(studente.getAnagrafica().getMatricola(), studente) == null;
    }

    //RECUPERA STUDENTE
    public Studente recuperaStudente (String matricola) {
        return registro.get(matricola);
    }

    //GENERA NUOVA MATRICOLA
    public String nuovaMatricola () {
        String matricola;
        do {
            matricola = "";
            for (int i = 0; i < 10; i++) {
                matricola += (int) (Math.random() * 10);
            }
        } while (registro.containsKey(matricola));
        return matricola;
    }

    //TO STRING
    @Override
    public String toString () {
        String r = "Lista studenti:";

        Set<String> keys = registro.keySet();

        for (String key : keys) {
            r += "\n  " + registro.get(key);
        }

        return r;
    }
}
