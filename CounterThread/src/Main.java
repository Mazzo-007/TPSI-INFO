public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        SumCounterThread t1 = new SumCounterThread(c);
        SumCounterThread t2 = new SumCounterThread(c);
        SubCounterThread t5 = new SubCounterThread(c);
        SubCounterThread t6 = new SubCounterThread(c);
        MultCounterThread t3 = new MultCounterThread(c);
        MultCounterThread t4 = new MultCounterThread(c);

        t1.start();
        t2.start();
        t5.start();
        t6.start();

        t1.join();
        t2.join();
        t5.join();
        t6.join();

        t3.start();
        t4.start();
        t3.join();
        t4.join();

        System.out.println("Valore: " + c.getValue());
    }
}