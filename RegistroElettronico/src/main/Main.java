package main;

import java.util.Scanner;

import registroElettronico.RegistroElettronico;
import registroElettronico.Studente;
import registroElettronico.Voto;

public class Main {
    public static void main(String[] args) {
        RegistroElettronico registro = new RegistroElettronico();
        Scanner scanner = new Scanner(System.in);
        int scelta;

        do {
            System.out.println("\n=== Menu Registro Elettronico ===");
            System.out.println("1. Visualizza lista studenti");
            System.out.println("2. Aggiungi nuovo studente");
            System.out.println("3. Aggiungi voto a studente");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    System.out.println(registro);;
                    break;
                case 2:
                    System.out.println("\n--- Aggiungi Studente ---");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Cognome: ");
                    String cognome = scanner.nextLine();
                    System.out.print("Telefono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    String matricola = registro.nuovaMatricola();
                    Studente nuovoStudente = new Studente(nome, cognome, telefono, email, matricola);
                    boolean aggiunto = registro.aggiungiStudente(nuovoStudente);
                    if (aggiunto) {
                        System.out.println("Studente aggiunto con matricola: " + matricola);
                    } else {
                        System.out.println("Errore: matricola già esistente.");
                    }
                    break;
                case 3:
                    System.out.println("\n--- Aggiungi Voto ---");
                    System.out.print("Inserisci matricola studente: ");
                    String matricolaStudente = scanner.nextLine();
                    Studente studente = registro.recuperaStudente(matricolaStudente);
                    if (studente == null) {
                        System.out.println("Studente non trovato.");
                    } else {
                        System.out.print("Data (GG/MM/AAAA): ");
                        String data = scanner.nextLine();
                        System.out.print("Tipo (1=S, 2=O, 3=P): ");
                        int tipo = scanner.nextInt();
                        System.out.print("Valore: ");
                        double valore = scanner.nextDouble();
                        scanner.nextLine(); // Consuma il newline
                        Voto voto = new Voto(data, tipo, valore);
                        studente.aggiungiVoto(voto);
                        System.out.println("Voto aggiunto con successo.");
                    }
                    break;
                case 4:
                    System.out.println("Uscita dal programma...");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        } while (scelta != 4);
    }
}