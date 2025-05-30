package room;

import client.Client;

import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

/***
 * contenere i clients
 * propagare la comunicazione
 */

public class Room{
    private Vector<Client> lista;

    public Room() {
        lista = new Vector<>();
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
