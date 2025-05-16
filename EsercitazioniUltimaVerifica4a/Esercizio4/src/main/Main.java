package main;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File f;
        BufferedWriter bw;
        String contenuto = "";
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++){
            System.out.println("Inserisci riga di testo: ");
            contenuto += (contenuto.length() != 0) ? "\n" + sc.nextLine() : sc.nextLine();
        }

        f = new File("src/Utilities/input.txt");

        if (!f.exists()) {
            f.createNewFile();
        }

        bw = new BufferedWriter(new FileWriter(f));

        bw.write(contenuto);
        bw.flush();

        bw.close();
    }
}