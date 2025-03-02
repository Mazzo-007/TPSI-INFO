package torreHanoi;

public class Colonna <T> extends Pila <T> {
    //ATTRIBUTI
    private String nomeColonna;
    private int dimensione;
    private int altezza;

    //METODI

    //COSTRUTTORI
    public Colonna (String nomeColonna, int startDim, int altezza) {
        this.nomeColonna = nomeColonna;
        dimensione = 0;
        this.altezza = altezza;
        inizializzaDischi(startDim);
    }

    //GET & SET
    public String getNomeColonna() {
        return nomeColonna;
    }

    public void setNomeColonna(String nomeColonna) {
        this.nomeColonna = nomeColonna;
    }

    public int getDimensione() {
        return dimensione;
    }

    public void setDimensione(int dimensione) {
        this.dimensione = dimensione;
    }

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    //PUSH
    @Override
    public void push (T element) {
        super.push(element);
        dimensione ++;
    }

    //POP
    @Override
    public T pop () {
        dimensione --;
        return super.pop();
    }

    //INIZIALIZZA DISCHI
    private void inizializzaDischi (int startDim) {
        for (int i = 0 ; i < startDim; i++) {
            push((T) new Disco(i));
        }
    }

    //TOSTRING
    @Override
    public String toString() {
        String r = "";

        for (int i = 0; i < altezza; i++) {
            for (int j = 0; j < dimensione; j ++) {
                r += 
            }
        }

        return r;
    }
}
