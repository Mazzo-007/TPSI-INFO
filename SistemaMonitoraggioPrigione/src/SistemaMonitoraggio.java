import java.util.ArrayList;
import java.util.Scanner;

public abstract class SistemaMonitoraggio {
    /**
     * ATTRIBUTI
     * */

    private int ID;
    private String nome;
    private ArrayList<Sensore> sensori;
    private Scanner sc = new Scanner(System.in);

    /**
     * COSTRUTTORI
     * */

    public SistemaMonitoraggio (int ID, String nome) {
        this.ID = ID;
        this.nome = nome;
        sensori = new ArrayList<>();
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

    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public ArrayList<Sensore> getSensori() {
        return sensori;
    }

    /**
     * AGGIUGNI SENSORE
     * */

    public void aggiungiSensore () {
        System.out.println ("1. Aggiungi sensore di temperatura\n2. Aggiungi sensore di movimento");
        System.out.print ("Scegli: ");
        int scelta = sc.nextInt();

        System.out.print ("Inserisci l'ID del sensore: ");
        int ID = sc.nextInt();

        switch (scelta) {
            case 1:
                sensori.add (new SensoreTemperatura (ID, 0));
                break;
            case 2:
                sensori.add (new SensoreMovimento (ID, 0));
                break;
            default:
                System.out.println ("Scelta inesistente");
        }
    }

    /**
     * RIMUOVI SENSORE
     * */

    public void rimuoviSensore () {
        System.out.print ("Che sensore vuoi rimuovere: ");
        int scelta = sc.nextInt ();
        sensori.remove (scelta);
    }

    /**
     * METODI ASTRATTI
     * */

    public abstract void calcoloStatistiche ();
}
