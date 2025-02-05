package rubrica;

import java.util.ArrayList;
import java.util.Scanner;

public class Contatto {
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------ATTRIBUTI---------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    private String nome, cognome, email, indirizzo, nota;
    private ArrayList<Numero> numeri;
    private final Scanner sc = new Scanner(System.in);

    //------------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------METODI-----------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    //COSTRUTTORE
    public Contatto (String nome, String cognome, ArrayList<Numero> numeri) {
        this.cognome = cognome;
        this.nome = nome;
        this.numeri = numeri;
        inizializzaOpzioni();
    }

    //INIZIALIZZA OPZIONI
    private void inizializzaOpzioni () {
        System.out.println("Opzioni aggiuntive (premere invio per saltare opzione)");
        System.out.print("Inserisci l'indirizzo email: ");
        email = sc.nextLine();
        System.out.print("Inserisci l'indirizzo: ");
        indirizzo = sc.nextLine();
        System.out.print("Inserisci la nota: ");
        nota = sc.nextLine();
    }

    //GET & SET
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public ArrayList<Numero> getNumeri() {
        return numeri;
    }

    public void setNumeri(ArrayList<Numero> numeri) {
        this.numeri = numeri;
    }

    //TO STRING

    @Override
    public String toString() {
        return "Contatto{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", nota='" + nota + '\'' +
                ", numeri=" + numeri +
                '}';
    }
}
