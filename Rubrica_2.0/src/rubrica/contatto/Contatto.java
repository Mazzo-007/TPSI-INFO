package rubrica.contatto;

import java.util.List;

public class Contatto {
    //ATTRIBUTI

    private String nome, cognome, mail, nota;
    private List<Numero> listaNumeri;

    //METODI

    //COSTRUTTORE
    public Contatto(String nome, String cognome, String mail, String nota, List<Numero> listaNumeri) {
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
        this.nota = nota;
        this.listaNumeri = listaNumeri;
    }

    //GET & SET
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public List<Numero> getListaNumeri() {
        return listaNumeri;
    }

    public void setListaNumeri(List<Numero> listaNumeri) {
        this.listaNumeri = listaNumeri;
    }

    //TO STRING

    @Override
    public String toString() {
        return "Contatto{" +
                "\n  nome = " + nome +
                ", \n  cognome = " + cognome +
                ", \n  mail = " + mail +
                ", \n  nota = " + nota +
                ", \n  listaNumeri = " + listaNumeri +
                "\n}";
    }

}
