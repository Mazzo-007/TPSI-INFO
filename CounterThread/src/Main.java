public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        counterThread t1 = new counterThread(c);
        counterThread t2 = new counterThread(c);

        //t1.run() LA MORTE!
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Valore: " + c.getValue());
    }
}