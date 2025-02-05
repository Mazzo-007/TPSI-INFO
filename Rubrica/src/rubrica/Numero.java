package rubrica;

public class Numero {
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------ATTRIBUTI---------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    private String telefono, tipo;

    //------------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------METODI-----------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    //COSTRUTTORE
    public Numero (String telefono, int tipo) {
        this.telefono = telefono;
        inizializzaTipo(tipo);
    }

    //INIZIALIZZA TIPO
    private void inizializzaTipo (int index) {
        tipo = Tipo.tipi[index];
    }

    //GET & SET
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //TO STRING
    @Override
    public String toString() {
        return "Numero{" +
                "telefono='" + telefono + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
