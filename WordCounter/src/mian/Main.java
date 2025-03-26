package mian;

import wordCounter.WordCounter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WordCounter wc = new WordCounter();
        Scanner sc = new Scanner(System.in);
        String text;

        System.out.println("Inserisci la frase su cui iterare il conteggio: ");
        text = sc.nextLine();

        HashMap<String, Integer> risultato = wc.textCount(text);

        System.out.println("\nTABELLA DELLE ITERAZIONI:");

        for (Map.Entry<String, Integer> entry : risultato.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}