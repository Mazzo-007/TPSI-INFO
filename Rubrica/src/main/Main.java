package rubrica;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rubrica rubrica = new Rubrica();
        System.out.println("Benvenuto nella tua Rubrica!");

        while (true) {
            // Menu principale
            System.out.println("\n=== MENU PRINCIPALE ===");
            System.out.println("1. Aggiungi Contatto");
            System.out.println("2. Modifica Contatto");
            System.out.println("3. Cancella Contatto");
            System.out.println("4. Aggiungi Numero a Contatto");
            System.out.println("5. Cerca Contatto");
            System.out.println("6. Visualizza Rubrica");
            System.out.println("7. Esci");
            System.out.print("Scegli un'opzione: ");

            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma la newline

            switch (scelta) {
                case 1:
                    aggiungiContatto(scanner, rubrica);
                    break;
                case 2:
                    modificaContatto(scanner, rubrica);
                    break;
                case 3:
                    cancellaContatto(scanner, rubrica);
                    break;
                case 4:
                    aggiungiNumero(scanner, rubrica);
                    break;
                case 5:
                    cercaContatto(scanner, rubrica);
                    break;
                case 6:
                    visualizzaRubrica(rubrica);
                    break;
                case 7:
                    System.out.println("Arrivederci!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opzione non valida. Riprova.");
            }
        }
    }

    // Metodo per aggiungere un contatto
    private static void aggiungiContatto(Scanner scanner, Rubrica rubrica) {
        System.out.println("\n--- Aggiungi Nuovo Contatto ---");
        System.out.print("Inserisci nome: ");
        String nome = scanner.nextLine();
        System.out.print("Inserisci cognome: ");
        String cognome = scanner.nextLine();
        System.out.print("Inserisci numero di telefono: ");
        String telefono = scanner.nextLine();
        System.out.print("Inserisci tipo di numero (1. Principale, 2. Abitazione, 3. Lavoro): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consuma la newline
        Numero numero = new Numero(telefono, tipo - 1); // Subtract 1 to match enum indexing
        System.out.print("Inserisci email: ");
        String email = scanner.nextLine();
        System.out.print("Inserisci indirizzo: ");
        String indirizzo = scanner.nextLine();
        System.out.print("Inserisci nota: ");
        String nota = scanner.nextLine();

        Contatto contatto = new Contatto(nome, cognome, numero, email, indirizzo, nota);
        rubrica.aggiungiContatto(contatto);
        System.out.println("Contatto aggiunto con successo!");
    }

    // Metodo per modificare un contatto
    private static void modificaContatto(Scanner scanner, Rubrica rubrica) {
        System.out.println("\n--- Modifica Contatto ---");
        System.out.print("Inserisci il nome del contatto da modificare: ");
        String nome = scanner.nextLine();
        ArrayList<Contatto> contattiTrovati = rubrica.cercaContatto(nome, 2); // Ricerca per nome

        if (contattiTrovati.isEmpty()) {
            System.out.println("Nessun contatto trovato con il nome: " + nome);
        } else {
            System.out.println("Contatti trovati:");
            for (Contatto c : contattiTrovati) {
                System.out.println(c);
            }
            System.out.print("Seleziona il contatto da modificare (inserisci nome): ");
            String nomeDaModificare = scanner.nextLine();
            Contatto contattoIniziale = contattiTrovati.stream()
                    .filter(c -> c.getNome().equals(nomeDaModificare))
                    .findFirst()
                    .orElse(null);

            if (contattoIniziale != null) {
                System.out.print("Inserisci nuovo nome: ");
                String nuovoNome = scanner.nextLine();
                System.out.print("Inserisci nuovo cognome: ");
                String nuovoCognome = scanner.nextLine();
                System.out.print("Inserisci nuova email: ");
                String nuovoEmail = scanner.nextLine();
                System.out.print("Inserisci nuovo indirizzo: ");
                String nuovoIndirizzo = scanner.nextLine();
                System.out.print("Inserisci nuova nota: ");
                String nuovaNota = scanner.nextLine();

                Contatto contattoModificato = new Contatto(nuovoNome, nuovoCognome, contattoIniziale.getNumeri().get(0), nuovoEmail, nuovoIndirizzo, nuovaNota);
                rubrica.modificaContato(contattoIniziale, contattoModificato);
                System.out.println("Contatto modificato con successo!");
            } else {
                System.out.println("Contatto non trovato.");
            }
        }
    }

    // Metodo per cancellare un contatto
    private static void cancellaContatto(Scanner scanner, Rubrica rubrica) {
        System.out.println("\n--- Cancella Contatto ---");
        System.out.print("Inserisci il nome del contatto da cancellare: ");
        String nome = scanner.nextLine();
        ArrayList<Contatto> contattiTrovati = rubrica.cercaContatto(nome, 2); // Ricerca per nome

        if (contattiTrovati.isEmpty()) {
            System.out.println("Nessun contatto trovato con il nome: " + nome);
        } else {
            System.out.println("Contatti trovati:");
            for (Contatto c : contattiTrovati) {
                System.out.println(c);
            }
            System.out.print("Seleziona il contatto da cancellare (inserisci nome): ");
            String nomeDaCancellare = scanner.nextLine();
            Contatto contattoDaCancellare = contattiTrovati.stream()
                    .filter(c -> c.getNome().equals(nomeDaCancellare))
                    .findFirst()
                    .orElse(null);

            if (contattoDaCancellare != null) {
                rubrica.cancellaContatto(contattoDaCancellare);
                System.out.println("Contatto cancellato con successo!");
            } else {
                System.out.println("Contatto non trovato.");
            }
        }
    }

    // Metodo per aggiungere un numero a un contatto
    private static void aggiungiNumero(Scanner scanner, Rubrica rubrica) {
        System.out.println("\n--- Aggiungi Numero a Contatto ---");
        System.out.print("Inserisci il nome del contatto a cui aggiungere un numero: ");
        String nome = scanner.nextLine();
        ArrayList<Contatto> contattiTrovati = rubrica.cercaContatto(nome, 2); // Ricerca per nome

        if (contattiTrovati.isEmpty()) {
            System.out.println("Nessun contatto trovato con il nome: " + nome);
        } else {
            System.out.println("Contatti trovati:");
            for (Contatto c : contattiTrovati) {
                System.out.println(c);
            }
            System.out.print("Seleziona il contatto a cui aggiungere un numero (inserisci nome): ");
            String nomeDaModificare = scanner.nextLine();
            Contatto contatto = contattiTrovati.stream()
                    .filter(c -> c.getNome().equals(nomeDaModificare))
                    .findFirst()
                    .orElse(null);

            if (contatto != null) {
                System.out.print("Inserisci numero di telefono da aggiungere: ");
                String telefono = scanner.nextLine();
                System.out.print("Inserisci tipo di numero (1. Principale, 2. Abitazione, 3. Lavoro): ");
                int tipo = scanner.nextInt();
                scanner.nextLine(); // Consuma la newline
                Numero numero = new Numero(telefono, tipo - 1); // Subtract 1 to match enum indexing

                rubrica.addNumeroToContatto(contatto, numero);
                System.out.println("Numero aggiunto con successo!");
            } else {
                System.out.println("Contatto non trovato.");
            }
        }
    }

    // Metodo per cercare un contatto
    private static void cercaContatto(Scanner scanner, Rubrica rubrica) {
        System.out.println("\n--- Cerca Contatto ---");
        System.out.print("Inserisci nome o cognome o numero di telefono da cercare: ");
        String ricerca = scanner.nextLine();
        System.out.print("Scegli tipo di ricerca (1. Cognome, 2. Nome, 3. Telefono): ");
        int tipoRicerca = scanner.nextInt();
        scanner.nextLine(); // Consuma la newline

        ArrayList<Contatto> trovati = rubrica.cercaContatto(ricerca, tipoRicerca);
        if (trovati.isEmpty()) {
            System.out.println("Nessun contatto trovato.");
        } else {
            System.out.println("Contatti trovati:");
            for (Contatto c : trovati) {
                System.out.println(c);
            }
        }
    }

    // Metodo per visualizzare la rubrica
    private static void visualizzaRubrica(Rubrica rubrica) {
        System.out.println("\n--- Rubrica ---");
        if (rubrica.getContatti().isEmpty()) {
            System.out.println("La rubrica è vuota.");
        } else {
            for (Contatto contatto : rubrica.getContatti()) {
                System.out.println(contatto);
            }
        }
    }
}
