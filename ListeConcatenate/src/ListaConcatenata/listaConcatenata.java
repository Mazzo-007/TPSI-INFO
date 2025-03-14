package ListaConcatenata;

import java.awt.*;

public class listaConcatenata {
    //ATTRIBUTI

    private Nodo head;

    //METODI

    //COSTRUTTORE
    public listaConcatenata (Nodo head) {
        this.head = head;
    }

    public listaConcatenata () {
        head = null;
    }

    //ADD NODO
    public void addNodo (Nodo newNodo) {
        Nodo temp;
        if (head == null) {
            head = newNodo;
        } else {
            temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNodo);
        }
    }

    //TO STRING
    @Override
    public String toString () {
        Nodo temp;

        String r = "Lista{";
        r += head;

        temp = head;
        while (temp != null) {
            temp = temp.getNext();
            r += " -> " + temp;
        }

        r += "}";
        return r;
    }
}
