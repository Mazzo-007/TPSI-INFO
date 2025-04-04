package main;

import esploraRisorse.EsploraRisorse;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Esplora Risorse Java ===");

        String initialPath = "X:\\Users\\mazzoni.luca\\Documents";
        EsploraRisorse esploraRisorse = new EsploraRisorse(initialPath);

        int choice;

        do {
            System.out.println("Percorso corrente: " + esploraRisorse.getDirectoryPath());
            System.out.println("1. Visualizza contenuto");
            System.out.println("2. Entra in una cartella");
            System.out.println("3. Torna alla cartella precedente");
            System.out.println("4. Crea un nuovo file");
            System.out.println("5. Crea una nuova cartella");
            System.out.println("6. Elimina un file/cartella");
            System.out.println("7. Mostra informazioni su un file");
            System.out.println("8. Esci");
            System.out.print("Scelta: ");

            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    esploraRisorse.stampaContenuto();
                    break;
                case 2:
                    System.out.print("Inserisci il nome della cartella da entrare: ");
                    String folderName = scanner.nextLine();
                    if (esploraRisorse.joinDir(folderName)) {
                        System.out.println("Entrato nella cartella: " + folderName);
                    } else {
                        System.out.println("Cartella non trovata.");
                    }
                    break;
                case 3:
                    if (esploraRisorse.backDir()) {
                        System.out.println("Tornato alla cartella precedente.");
                    } else {
                        System.out.println("Sei già nella directory principale.");
                    }
                    break;
                case 4:
                    System.out.print("Inserisci il nome del nuovo file: ");
                    String fileName = scanner.nextLine();
                    File newFile = new File(esploraRisorse.getDirectoryPath() + "\\" + fileName);
                    esploraRisorse.createFile(newFile);
                    break;
                case 5:
                    System.out.print("Inserisci il nome della nuova cartella: ");
                    String dirName = scanner.nextLine();
                    esploraRisorse.createDir(dirName);
                    break;
                case 6:
                    System.out.print("Inserisci il nome del file/cartella da eliminare: ");
                    String toDelete = scanner.nextLine();
                    if (esploraRisorse.deleteFileDir(toDelete)) {
                        System.out.println("File/cartella eliminato " + toDelete);
                    } else {
                        System.out.println("File/cartella non trovato.");
                    }
                    break;
                case 7:
                    System.out.print("Inserisci il nome del file di cui mostrare le informazioni: ");
                    String infoFileName = scanner.nextLine();
                    esploraRisorse.showFileInfo(infoFileName);
                    break;
                case 8:
                    System.out.println("Uscita dall'applicazione.");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }

            System.out.println();  // Print a new line for better readability

        } while (choice != 8);
    }
}