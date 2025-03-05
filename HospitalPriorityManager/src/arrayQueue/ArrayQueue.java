package arrayQueue;

import java.util.ArrayList;

public class ArrayQueue <T> {
    //ATTRIBUTI

    private ArrayList<T> queue;

    //METODI

    //COSTRUTTORE
    public ArrayQueue () {
        queue = new ArrayList<>();
    }

    //PUSH
    public void push (T e) {
        queue.add(e);
    }

    //POP
    public T pop () {
        if (!queue.isEmpty()) return queue.remove(0);
        return null;
    }

    //TOP
    public T top () {
        if (!queue.isEmpty()) return queue.get(0);
        return null;
    }

    //IS EMPTY
    public boolean isEmpty () {
        return queue.isEmpty();
    }

    //SIZE
    public int size () {
        return queue.size();
    }
}
