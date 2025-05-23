import java.util.HashMap;

public class GestoreRoom {
    private HashMap<String, Room> stanze;

    public GestoreRoom () {
        stanze = new HashMap<>();
    }

    public boolean addRoom (String ID, Room room) {
        if (stanze.containsKey(ID)) {
            return false;
        }
        stanze.put(ID, room);
        return true;
    }

    public boolean deleteRoom (String ID) {
        if (stanze.containsKey(ID)) {
            return false;
        }
        stanze.remove(ID);
        return true;
    }

    public Room getRoom (String ID) {
        if (!stanze.containsKey(ID)) return null;
        return stanze.get(ID);
    }
}
