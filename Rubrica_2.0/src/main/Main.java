package main;

import persistenceManager.fileEditor;
import rubrica.contatto.Contatto;
import rubrica.contatto.Numero;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Numero> listaNumeri = new ArrayList<>();

        listaNumeri.add(new Numero("3515167800", "Cellulare"));
        listaNumeri.add(new Numero("3397491937", "papa"));

        Contatto c = new Contatto("luca", "mazzoni", "luca.mazzoni@gmail.com", "io", listaNumeri);

        System.out.println(c);

        File f = new File("C:\\Users\\mazzo\\Desktop\\prova\\prova.txt");

        fileEditor.write(f, "Questa è una prova\nvediamo cosa stampa");

        System.out.println(fileEditor.read(f));
    }
}