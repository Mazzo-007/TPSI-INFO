package rubrica;

import rubrica.contatto.Contatto;

import java.util.ArrayList;
import java.util.List;

public class Rubrica {
    //ATTRIBUTI

    List<Contatto> contatti;

    //METODI

    //COSTRUTTORE
    public Rubrica() {
        contatti = new ArrayList<>();
    }

    //CANCELLA CONTATTO
    public Contatto cancellaContatto (Contatto contatto) {
        Contatto r;
        if (contatti.contains(contatto)) {
            r = contatti.get(contatti.indexOf(contatto));
            contatti.remove(contatto);
            return r;
        }
        return null;
    }

    //ORDINA
    private void ordina () {
        Contatto appoggio;
        for (int i = 0; i < contatti.size() - 1; i++) {
            if (contatti.get(i).getNome().compareTo(contatti.get(i+1).getNome()) > 0) {
                appoggio = contatti.get(i);
                contatti.set(i, contatti.get(i+1));
                contatti.set(i+1, appoggio);
            } else if (contatti.get(i).getNome().compareTo(contatti.get(i+1).getNome()) == 0) {
                if (contatti.get(i).getNome().compareTo(contatti.get(i+1).getNome()) > 0) {
                    appoggio = contatti.get(i);
                    contatti.set(i, contatti.get(i+1));
                    contatti.set(i+1, appoggio);
                }
            }
        }
    }
}
