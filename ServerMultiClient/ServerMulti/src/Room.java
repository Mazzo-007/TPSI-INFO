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
    private GestoreRoom gr;

    public Room(String ID, GestoreRoom gr) {
        this.ID = ID;
        lista = new Vector<>();
        this.gr = gr;
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
        if(lista.remove(c)) {
            Room r = gr.getRoom("INFO");
            r.addInfo(r,c);
        }
    }

    private void addInfo(Room info, Client c){
        info.getLista().add(c);
    }

    public Vector<Client> getLista(){
        return lista;
    }
}