import eccezioni.BlackoutException;
import eccezioni.NoIngredientException;
import eccezioni.RifornimentoException;
import ristorante.Piatto;
import ristorante.Ristorante;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Ristorante r = new Ristorante("O'PrimmAmmore", 25);
        String[] Piatti = {
                "Pasta",
                "Riso",
                "Carne"
        };
        String piatto;

        while (true) {
            piatto = Piatti[(int) (Math.random()*(Piatti.length))];
            try {
                r.simula(piatto);
            } catch (BlackoutException e) {
                System.out.println(e.getMessage());
                Thread.sleep(7000);
            } catch (NoIngredientException e) {
                System.out.println(e.getMessage());
            } catch (RifornimentoException e) {
                System.out.println(e.getMessage());
                r.update(10);
            }
        }
    }
}