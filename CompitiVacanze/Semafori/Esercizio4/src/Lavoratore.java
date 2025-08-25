public class Lavoratore extends Thread {
    private String name;
    private Barriera b;

    public Lavoratore (String name, Barriera b) {
        this.name = name;
        this.b = b;
    }

    @Override
    public void run () {
        System.out.println("Il lavoratore "+ name + " è partito");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Il lavoratore " + name + " ha raggiunto la bariera");
        try {
            Thread.sleep(2000);
            b.aspetto();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Il lavoratore " + name + " ha superato la bariera");
    }
}