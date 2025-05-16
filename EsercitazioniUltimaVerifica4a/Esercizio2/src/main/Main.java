package main;

import java.io.*;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "src\\Utilities\\input.txt";
        File input = new File(path);
        BufferedReader br;
        String riga, contenuto = "";
        if (input.exists() && input.canRead()) {
            br = new BufferedReader(new FileReader(input));
            while ((riga = br.readLine()) != null) {
                contenuto += (contenuto.length() != 0) ? "\n" + riga : riga;
            }
            System.out.println("CONTENUTO:\n" + contenuto);
            br.close();
        }
    }
}