import java.util.concurrent.Semaphore;

public class Counter {
    private double value;

    public void add (double amount) {
        value += amount;
    }

    public void mult (double amount) {
        value *= amount;
    }

    public void sub (double amount) {
        value -= amount;
    }

    public double getValue () {
        return value;
    }
}
