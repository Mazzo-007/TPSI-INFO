class Compratore extends Thread {
    private Botteghino botteghino;
    private String nome;

    public Compratore (Botteghino b, String nome) {
        this.botteghino = b;
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int)(Math.random() * 3000));

            boolean riuscito = botteghino.compraBiglietto(nome);

            if (!riuscito) {
                System.out.println(nome + " non è riuscito a comprare il biglietto.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
