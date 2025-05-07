package main;

import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileWriter fw;
        String contenuto = "";
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++){
            System.out.println("Inserisci riga di testo: ");
            contenuto += (contenuto.length() != 0) ? "\n" + sc.nextLine() : sc.nextLine();
        }
        System.out.println(contenuto);
    }
}