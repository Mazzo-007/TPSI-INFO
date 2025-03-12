package priorityManager;

public class PriorityManager {
    //ATTRIBUTI

    private coda<Paziente>[] code;

    //METODI

    //COSTRUTTORE
    public PriorityManager () {
        code = new coda[] {
                new coda<Paziente>("Basso"),
                new coda<Paziente>("Moderato"),
                new coda<Paziente>("Critico")
        };
    }

    //AGGIUNGI PAZIENTE
    public void aggiungiPaziente (Paziente p) {
        switch (p.getPriorityLevel()) {
            case 1 -> code[0].push(p);
            case 2 -> code[1].push(p);
            case 3 -> code[2].push(p);
        }
    }

    //STAMPA CODA
    public String stampaCoda (int index) {
        try {
            return code[index].toString();
        } catch (NullPointerException e) {
            return "Indice di coda inesistente";
        }
    }

    //ESEGUI TRATTAMENTO
    public String eseguiTrattamento () {
        for (int i = 2; i >= 0; i--) {
            if (!code[i].isEmpty()) {
                return "E' stato trattato nella coda livello " + code[i].getNomeCoda() + " il paziente: " + code[i].pop();
            }
        }
        return "Nessun paziente presente";
    }
}
