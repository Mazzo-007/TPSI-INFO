package rubrica;

import java.util.ArrayList;

public class Rubrica {
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------ATTRIBUTI---------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    private ArrayList<Contatto> contatti;

    //------------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------METODI-----------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    //COSTRUTTORE
    public Rubrica () {
        contatti = new ArrayList<>(1);
    }

    //GET CONTATTI
    public ArrayList<Contatto> getContatti() {
        return contatti;
    }

    //AGGIUNGI CONTATTO
    public boolean aggiungiContatto (Contatto contatto) {
        contatti.add(contatto);
        ordina();
        return true;
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

    //MODIFICA CONTATTO
    public Contatto modificaContato (Contatto contattoIniziale, Contatto contattoModificato) {
        if (contatti.contains(contattoIniziale)) {
            contatti.set(contatti.indexOf(contattoIniziale), contattoModificato);
            return contatti.get(contatti.indexOf(contattoIniziale));
        }
        return null;
    }

    //AGGIUNGI NUMERO A CONTATTO
    public boolean addNumeroToContatto (Contatto contatto, Numero numero) {
        Contatto appoggio;
        if (contatti.contains(contatto)) {
            appoggio = contatti.get(contatti.indexOf(contatto));
            appoggio.addNumeri(numero);
            contatti.set(contatti.indexOf(contatto), appoggio);
            return true;
        }
        return false;
    }

    //CERCA CONTATTO
    public ArrayList<Contatto> cercaContatto (String ricerca, int tipoRicerca) {
        int lenghtRicerca;
        ArrayList<Contatto> trovati = new ArrayList<>();
        for (int i = 0; i < contatti.size(); i++) {
            switch (tipoRicerca) {
                case 1:
                    lenghtRicerca = ricerca.length();
                    if (contatti.get(i).getCognome().length() > lenghtRicerca) {
                        if (contatti.get(i).getCognome().substring(0, lenghtRicerca-1).equals(ricerca))
                            trovati.add(contatti.get(i));
                    } else if (contatti.get(i).getCognome().length() == lenghtRicerca) {
                        if (contatti.get(i).getCognome().equals(ricerca))
                            trovati.add(contatti.get(i));
                    }
                    break;
                case 2:
                    lenghtRicerca = ricerca.length();
                    if (contatti.get(i).getNome().length() > lenghtRicerca) {
                        if (contatti.get(i).getNome().substring(0, lenghtRicerca-1).equals(ricerca))
                            trovati.add(contatti.get(i));
                    } else if (contatti.get(i).getNome().length() == lenghtRicerca) {
                        if (contatti.get(i).getNome().equals(ricerca))
                            trovati.add(contatti.get(i));
                    }
                    break;
                case 3:
                    for (Numero n : contatti.get(i).getNumeri()) {
                        if (n.getTelefono().equals(ricerca)){
                            trovati.add(contatti.get(i));
                            break;
                        }
                    }
                    break;
            }
        }
        return trovati;
    }

    //ORDINA
    private void ordina() {
        Contatto appoggio;
        for (int i = 0; i < contatti.size() - 1; i++) {
            if (contatti.get(i).getCognome().compareTo(contatti.get(i + 1).getCognome()) > 0) {
                appoggio = contatti.get(i);
                contatti.set(i, contatti.get(i + 1));
                contatti.set(i + 1, appoggio);
            } else if (contatti.get(i).getCognome().compareTo(contatti.get(i + 1).getCognome()) == 0) {
                if (contatti.get(i).getNome().compareTo(contatti.get(i + 1).getNome()) > 0) {
                    appoggio = contatti.get(i);
                    contatti.set(i, contatti.get(i + 1));
                    contatti.set(i + 1, appoggio);
                }
            }
        }
    }
}
