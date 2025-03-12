package main;

import priorityManager.Paziente;
import priorityManager.PriorityManager;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static int selettore = 0;
    public static Scanner sc = new Scanner(System.in);
    public static boolean errorChecker;
    public static PriorityManager gestore;

    public static void stampaCodaOspedaliera () {
        do {
            System.out.println("STAMPA CODA OSPEDALIERA:");
            System.out.println("Code:\n  1. Coda livello basso\n  2. Coda livello moderato\n  3. Coda livello critico");
            System.out.print("Seleziona: ");
            try {
                errorChecker = false;
                selettore = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Inserisci un corretto input");
                errorChecker = true;
            }
            if (selettore < 1 || selettore > 3) {
                System.out.println("L'input deve essere compreso tra 1 e 3");
                errorChecker = true;
            }
        } while (errorChecker);

        System.out.println(gestore.stampaCoda(selettore-1));
    }

    public static void aggiugniPazienteCoda () {
        int selettoreCoda = 0;
        String nomePaziente, cognomePaziente;

        do {
            System.out.println("AGGIUNGI PAZIENTE A CODA OSPEDALIERA:");
            System.out.println("Code:\n  1. Coda livello basso\n  2. Coda livello moderato\n  3. Coda livello critico");
            System.out.print("Seleziona: ");
            try {
                errorChecker = false;
                selettoreCoda = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Inserisci un corretto input");
                errorChecker = true;
            }
            if (selettoreCoda < 1 || selettoreCoda > 3) {
                System.out.println("L'input deve essere compreso tra 1 e 3");
                errorChecker = true;
            }
        } while (errorChecker);

        System.out.print("Inserisci il nome del paziente: ");
        nomePaziente = sc.next();
        System.out.print("Inserisci il cognome del paziente: ");
        cognomePaziente = sc.next();

        gestore.aggiungiPaziente(new Paziente(nomePaziente, cognomePaziente, selettoreCoda));
    }

    public static void main(String[] args) {
        boolean menu = true;
        gestore = new PriorityManager();

        do {
            do {
                System.out.println("GESTORE PRIORITA' OSPEDALIERE:");
                System.out.println("Opzioni:\n  1. Stampa coda\n  2. Aggiungi paziente\n  3. Effettua trattamento\n  4. Chiudi");
                System.out.print("Seleziona: ");
                try {
                    errorChecker = false;
                    selettore = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Inserisci un corretto input");
                    errorChecker = true;
                }
            } while (errorChecker);

            switch (selettore) {
                case 1 -> stampaCodaOspedaliera();
                case 2 -> aggiugniPazienteCoda();
                case 3 -> System.out.println(gestore.eseguiTrattamento());
                case 4 -> {
                    System.out.println("Chiusura programma");
                    menu = false;
                }
                default -> System.out.println("L'input deve essere compreso tra 1 e 4");
            }
        } while (menu);
    }
}