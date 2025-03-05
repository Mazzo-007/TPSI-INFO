package priorityManager;

public class Paziente {
    //ATTRIBUTI

    private String nome, cognome, priorityColor;
    private int priorityLevel;

    //METODI

    //COSTRUTTORE
    public Paziente(String nome, String cognome, int priorityLevel) {
        this.nome = nome;
        this.cognome = cognome;
        this.priorityLevel = priorityLevel;

        setPriorityColor();
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

    public String getPriorityColor() {
        return priorityColor;
    }

    private void setPriorityColor() {
        switch (priorityLevel) {
            case 1 -> priorityColor = "Verde";
            case 2 -> priorityColor = "Giallo";
            case 3 -> priorityColor = "Rosso";
        }
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
        setPriorityColor();
    }

    //TO STRING
    @Override
    public String toString() {
        return "Paziente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", priorityColor='" + priorityColor + '\'' +
                '}';
    }
}
