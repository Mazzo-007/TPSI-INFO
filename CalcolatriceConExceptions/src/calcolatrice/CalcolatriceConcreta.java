package calcolatrice;

import java.util.ArrayList;

public class CalcolatriceConcreta implements Calcolatrice {
    private double risultato;

    private String operazione;

    private ArrayList<String> log;

    public CalcolatriceConcreta () {
        log = new ArrayList<>(2);
    }

    @Override
    public String somma (double a, double b) {
        operazione = a + " + " + b + " = ";
        risultato = a + b;
        aggiornaLog(operazione + risultato, null);
        return "" + risultato;
    }

    @Override
    public String sottrazione (double a, double b) {
        operazione = a + " - " + b + " = ";
        risultato = a - b;
        aggiornaLog(operazione + risultato, null);
        return "" + risultato;
    }

    @Override
    public String moltiplicazione (double a, double b) {
        operazione = a + " * " + b + " = ";
        risultato = a * b;
        aggiornaLog(operazione + risultato, null);
        return "" + risultato;
    }

    @Override
    public String divisione (double a, double b) {
        operazione = a + " / " + b + " = ";
        try {
            risultato = a / b;
        } catch (ArithmeticException e) {
            aggiornaLog(operazione + "impossibile", e);
            return "Operazione impossibile";
        }
        aggiornaLog(operazione + risultato, null);
        return "" + risultato;
    }

    private void aggiornaLog (String risultato, Exception e) {
        log.add(risultato);
        log.add(e.getMessage());
    }

    @Override
    public String toString() {
        return "CalcolatriceConcreta{" +
                "log=" + log +
                '}';
    }
}
