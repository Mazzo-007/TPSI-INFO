package RivenditaVeicoli;

public class Rivendita {
    //------------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------ATTRIBUTI------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    private String nome;
    private Veicolo[] listaVeicoli;

    //------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------METODI-------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    //COSTRUTTORE
    public Rivendita(String nome, Veicolo[] listaVeicoli) {
        this.nome = nome;
        this.listaVeicoli = listaVeicoli;
    }

    public Rivendita(String nome, int numeroVeicoli) {
        this.nome = nome;
        listaVeicoli = new Veicolo[numeroVeicoli];
    }

    //GET & SET
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //ADD
    public boolean add (Veicolo v) {
        for (int i = 0; i < listaVeicoli.length; i++) {
            if (listaVeicoli[i] == null) {
                listaVeicoli[i] = v;
                return true;
            }
        }
        return false;
    }

    //READ
    public String read() {
        String s = nome + "{";
        for (Veicolo veicolo : listaVeicoli) {
            if (veicolo != null) {
                s +=  "\n   " + veicolo.descrivi();
            }
        }
        s += "\n}";
        return s;
    }

    public String read(int index) {
        if (index < listaVeicoli.length && listaVeicoli[index] != null) {
            return nome +
                    "(alla posizione: " +
                    index +
                    "){" + "\n   " +
                    listaVeicoli[index].descrivi() +
                    "\n}";
        }
        return "";
    }
}
