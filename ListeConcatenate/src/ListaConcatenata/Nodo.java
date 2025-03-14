package ListaConcatenata;

public class Nodo <T> {
    //ATTRIBUTI

    private T dato;
    private Nodo next;

    //METODI

    //COSTRUTTORE
    public Nodo (T dato) {
        this.dato = dato;
        next = null;
    }

    //GET & SET
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    //TO STRING
    @Override
    public String toString() {
        return "Nodo{" +
                "dato=" + dato +
                '}';
    }
}
