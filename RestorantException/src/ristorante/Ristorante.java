package ristorante;

import eccezioni.BlackoutException;
import eccezioni.NoIngredientException;
import eccezioni.RifornimentoException;

import java.util.ArrayList;
import java.util.List;

public class Ristorante {
    //ATTRIBUTI

    private String nomeRist;
    private List<Piatto> menu;
    private int nIngredienti;

    //METODI

    //COSTRUTTORE
    public Ristorante(String nomeRist, int nIngredienti) {
        this.nomeRist = nomeRist;
        this.nIngredienti = nIngredienti;
        menu = new ArrayList<>();
        menu.add(new Piatto("Pasta", 3, 2000));
        menu.add(new Piatto("Riso", 5, 4000));
        menu.add(new Piatto("Carne", 2, 8000));
    }

    //SIMULA
    public void simula (String piatto) throws BlackoutException, InterruptedException, NoIngredientException, RifornimentoException {
        //10%
        double prob = Math.random();

        if (prob < 0.1) throw new BlackoutException("Si è verificato un blackout. Stop per 7 secondi");

        //SERVI
        for (Piatto p: menu) {
            if (p.getNome().equals(piatto)) {
                if (p.getnIngredienti() <= nIngredienti) {
                    System.out.println("Sto preparando..." + piatto + "...");
                    Thread.sleep(p.getTempoPreparazione());
                    System.out.println("Servo..." + piatto + "!");
                } else {
                    throw new NoIngredientException("Ingredienti insufficenti");
                }
            }
        }

        //30%
        prob = Math.random();
        if (prob < 0.3) throw new RifornimentoException("E' arrivato un nuovo rifornimento!");
    }

    //UPDATE
    public void update (int newIngredient) {
        nIngredienti += newIngredient;
    }
}
