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
}
