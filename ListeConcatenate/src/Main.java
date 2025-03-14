import ListaConcatenata.listaConcatenata;
import ListaConcatenata.Nodo;

public class Main {
    public static void main(String[] args) {
        listaConcatenata lista = new listaConcatenata(new Nodo<>(1));
        for (int i = 2; i <= 10; i++) {
            lista.addNodo(new Nodo(i));
        }
        System.out.println(lista);
    }
}