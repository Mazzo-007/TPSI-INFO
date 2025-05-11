package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        String contenuto = "", riga;
        String[] parole;
        int counter;

        br = new BufferedReader(new FileReader("src/Utilities/input.txt"));

        while ((riga = br.readLine()) != null) {
            contenuto += (contenuto.length() != 0) ? "\n" + riga : riga;
        }

        parole = contenuto.split(" |\\n");

        counter = parole.length;

        System.out.println("Nel file sono presenti " + counter + " parole");
    }
}