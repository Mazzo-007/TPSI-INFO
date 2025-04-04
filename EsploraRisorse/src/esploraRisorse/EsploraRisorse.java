package esploraRisorse;

import java.io.File;
import java.io.IOException;

public class EsploraRisorse {
    //ATTRIBUTI

    private String directoryPath;
    private File directory;


    //METODI

    //COSTRUTTORE
    public EsploraRisorse(String directorypath){
        this.directoryPath = directorypath;
        directory = new File(directorypath);
    }

    //STAMPA CONTENUTO
    public void stampaContenuto() {
        File[] listFiles = directory.listFiles();

        if (listFiles != null) {
            for (File f : listFiles) {
                System.out.println((f.isDirectory() ? "[DIR] " : "[FILE] ") + f.getName());
            }
        } else {
            System.out.println("Empty directory");
        }
    }

    //JOIN DIR
    public boolean joinDir(String nome){
        directory = new File(directoryPath + "\\" + nome);

        if (directory.exists()) {
            directoryPath = directory.getAbsolutePath();
            return true;
        }

        directory = new File(directoryPath);
        return false;
    }

    //BACK DIR
    public boolean backDir(){
        if (directory.getParent() != null) {
            directoryPath = directory.getParent();
            directory = new File(directoryPath);
            return true;
        }
        return false;
    }

    //CREATE FILE
    public boolean createFile(File file) {
        try {
            if(file.createNewFile()){
                System.out.println("File created in the path: " + file.getAbsolutePath());
                return true;
            } else {
                System.out.println("File already exists in: " + file.getAbsolutePath());
            }
        } catch (IOException e){
            System.out.println("Encountered an unrecoverable error "+ e.getMessage());
        }
        return false;
    }

    //CREATE DIR
    public boolean createDir() {
        if(!directory.exists()){
            if(directory.mkdir()){
                System.out.println("Directory created: "+directoryPath);
                return true;
            } else {
                System.out.println("Can not create the directory");
                return false;
            }

        }else{
            System.out.println("Directory already exists");
            return false;
        }
    }

    //DELATE FILE DIRECTORY
    public boolean deleteFileDir(String nome){
        File tmp = new File(directoryPath + "\\" + nome);

        if(tmp.exists()) {
            tmp.delete();
            return true;
        }

        return false;
    }

    //SHOW FILE INFO
    public void showFileInfo(String nome) {
        File temp = new File(nome);

        if (temp.exists()) {
            System.out.print((temp.isDirectory() ? "[DIR] " : "[FILE] ") + temp.getName());
            System.out.print(" Path: " + temp.getAbsolutePath());
            System.out.print(" Last modified: " + temp.lastModified());
            System.out.print(" Size: " + temp.length());
            System.out.println(" Permits: " + (temp.canRead() ? "Read " : "") + (temp.canWrite() ? "Write " : "") + (temp.canExecute() ? "Execute " : ""));
        }

        System.out.println("The file or the directory is not accessible or does not exist");
    }
}
