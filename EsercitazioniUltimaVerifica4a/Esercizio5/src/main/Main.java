package main;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        BufferedWriter bw;
        File origin;
        File destination;
        Scanner sc = new Scanner(System.in);
        boolean controllo;
        String contenuto = "", riga;

        do {
            controllo = false;
            System.out.print("Inserisci il percorso del file di origine: ");
            origin = new File(sc.next());

            if (!(origin.exists() && origin.canRead() && origin.isFile())) {
                System.out.println("Il percorso specificato non indica un file esistente o punta una directory o non è leggibile");
                controllo = true;
            }
        } while (controllo);

        System.out.print("Inserisci il percorso del file di destinazione: ");
        destination = new File(sc.next());

        if (!(destination.exists() && destination.canWrite() && destination.isFile())) {
            System.out.println("Procedo alla creazione con il percorso indicato");
            destination.createNewFile();
        }

        br = new BufferedReader(new FileReader(origin));
        bw = new BufferedWriter(new FileWriter(destination));

        while ((riga = br.readLine()) != null) {
            contenuto += (contenuto.length() != 0) ? "\n" + riga : riga;
        }

        br.close();

        bw.write(contenuto);

        bw.flush();

        bw.close();

        System.out.println("Copia completata");
    }
}