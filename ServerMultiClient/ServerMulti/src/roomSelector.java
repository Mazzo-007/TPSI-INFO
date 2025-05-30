public class roomSelector extends Thread {
    private Room room;
    private Client c;

    public roomSelector(Room room, Client c) {
        this.room = room;
        this.c = c;
        this.start();
    }

    @Override
    public void run () {
        room.trasmetti("Stanze:", c);
    }
}

