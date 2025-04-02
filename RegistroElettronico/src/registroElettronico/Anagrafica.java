package registroElettronico;

public class Anagrafica {
    //ATTRIBUTI
    private String nome, cognome, telefono, email, matricola;

    //METODI
    //COSTRUTTORE
    public Anagrafica (String nome, String cognome, String telefono, String email, String matricola) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.email = email;
        this.matricola = matricola;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricola() {
        return matricola;
    }

    //TO STRING
    @Override
    public String toString() {
        return "  Anagrafica{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", matricola='" + matricola + '\'' +
                '}';
    }
}
