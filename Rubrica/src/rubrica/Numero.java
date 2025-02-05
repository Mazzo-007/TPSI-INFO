package rubrica;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Numero {
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------ATTRIBUTI---------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    private String telefono, tipo;
    private final Scanner sc = new Scanner(System.in);

    //------------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------METODI-----------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    //COSTRUTTORE
    public Numero (String telefono) {
        this.telefono = telefono;
        inizializzaTipo();
    }

    //INIZIALIZZA TIPO
    private void inizializzaTipo () {
        int scelta;
        boolean controllo;

        do {
            controllo = false;
            try {
                System.out.print("Tipi di numero:\n   1. Principale\n   2. Abitazione\n   3. Lavoro\nScegli: ");
                scelta = sc.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("Error: Input non valido!");
                controllo = true;
                break;
            }

            sc.nextLine();

            switch (scelta) {
                case 1 -> tipo = "Principale";
                case 2 -> tipo = "Abitazione";
                case 3 -> tipo = "Lavoro";
                default -> {
                    System.out.println("Error: Valore inesistente! Inserire un numero tra 1 e 3");
                    controllo = true;
                }
            }
        }while (controllo);
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
