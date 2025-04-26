package main;

import persistenceManager.fileEditor;
import rubrica.Rubrica;
import rubrica.contatto.Contatto;
import rubrica.contatto.Numero;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Rubrica r = new Rubrica();
        System.out.println(r.getSavingDir());
        System.out.println(r.getAutoInc());

        System.out.println(fileEditor.read(r.getResourcesPath()));
    }
}