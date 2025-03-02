package torreHanoi;

import java.util.ArrayList;

public abstract class Pila <T> {
    //ATRIBUTI
    private ArrayList<T> pila;

    //METODI

    //COSTRUTTORI
    public Pila () {
        pila = new ArrayList<>();
    }

    //PUSH
    public void push (T element) {
        pila.add(element);
    }

    //POP
    public T pop () {
        return pila.removeLast();
    }

    //TOP
    public T top () {
        return pila.getLast();
    }

    //IS EMPTY
    public boolean isEmpty () {
        return pila.isEmpty();
    }

    //SIZE
    public int size () {
        return pila.size();
    }
}
