import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

/***
 * contenere i clients
 * propagare la comunicazione
 */

public class Room{
    private Vector<Client> lista;
    private String ID;

    public Room(String ID) {
        this.ID = ID;
        lista = new Vector<>();
    }

    public String getID() {
        return ID;
    }

    public void addClient(Socket s) throws IOException, InterruptedException {
        lista.add(new Client(s,this));
    }

    public void trasmetti(String sms,Client utente){
        for(Client c : lista){
            if(!c.equals(utente))
                c.send(sms);
        }
    }
    public void abbandona(Client c){
        lista.remove(c);
    }
}