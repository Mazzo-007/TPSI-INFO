package main;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "src\\Utilities\\input.txt";
        File input = new File(path);
        FileReader fr;
        int carattere;
        String contenuto = "";
        if (input.exists() && input.canRead()) {
            fr = new FileReader(input);
            while ((carattere = fr.read()) != -1) {
                contenuto += (char) carattere;
            }
            System.out.println("CONTENUTO:\n" + contenuto);
            fr.close();
        }
    }
}