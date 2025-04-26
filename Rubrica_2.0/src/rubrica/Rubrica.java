package rubrica;

import persistenceManager.fileEditor;
import rubrica.contatto.Contatto;

import java.io.*;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Scanner;

public class Rubrica {
    //ATTRIBUTI

    private HashMap<Integer, Contatto> contatti;
    private int autoInc;
    private String SavingDir;
    private File resourcesPath;
    private Scanner sc;

    //METODI

    //COSTRUTTORE
    public Rubrica () {
        contatti = new HashMap<Integer, Contatto>();
        sc = new Scanner(System.in);
        inizializer();
    }

    //INIZIALIZER
    private void inizializer() {
        String setupRes;
        String[] setup;

        try {
            resourcesPath = new File(getClass().getClassLoader().getResource("setup.txt").toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        setupRes = fileEditor.read(resourcesPath);

        if (setupRes != null && !setupRes.isEmpty()) {
            setup = setupRes.split("\n");

            if (setup.length >= 2) {
                SavingDir = setup[0].substring(12).trim();
                autoInc = 0;
                try {
                    autoInc = Integer.parseInt(setup[1].substring(14).trim());
                } catch (NumberFormatException e) {
                    // Se non c'è nessun valore dopo "AutInc value:", rimane 0
                    System.out.println("Nessun valore di autoInc trovato, impostato a 0");
                }
            } else {
                firstUse();
            }
        } else {
            firstUse();
        }
    }

    //FIRST USE
    private void firstUse () {
        autoInc = 0;

        // Copia il file "setup.txt" dalla risorsa alla cartella di salvataggio
        File destFile = new File(SavingDir, "setup.txt");
        if (!destFile.exists()) {
            try (InputStream in = getClass().getClassLoader().getResourceAsStream("setup.txt");
                 OutputStream out = new FileOutputStream(destFile)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Chiedi all'utente dove salvare i contatti
        do {
            System.out.print("Inserisci il percorso assoluto della cartella dove salvare i tuoi contatti: ");
            SavingDir = sc.next();
        } while (!(new File(SavingDir).exists()) && new File(SavingDir).isFile());

        // Scrivi i dati nel file setup.txt
        String contenuto = "Saving dir: " + SavingDir + "\nAutInc value: " + autoInc;
        fileEditor.write(destFile, contenuto);
    }

    //GET & SET
    public HashMap<Integer, Contatto> getContatti() {
        return contatti;
    }

    public void setContatti(HashMap<Integer, Contatto> contatti) {
        this.contatti = contatti;
    }

    public int getAutoInc() {
        return autoInc;
    }

    public void setAutoInc(int autoInc) {
        this.autoInc = autoInc;
    }

    public String getSavingDir() {
        return SavingDir;
    }

    public void setSavingDir(String savingDir) {
        SavingDir = savingDir;
    }

    public File getResourcesPath() {
        return resourcesPath;
    }

    public void setResourcesPath(File resourcesPath) {
        this.resourcesPath = resourcesPath;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
}
