public class Main {
    public static void main(String[] args) {
        Botteghino b = new Botteghino();

        for (int i = 1; i <= 200; i++) {
            new Compratore(b, "Compratore-" + i).start();
        }
    }
}