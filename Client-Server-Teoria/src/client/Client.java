package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private String host; //l'indirizzo IP del server
    private int port; //il numero di porta del serverin cui è in ascolto il programma
    private Socket socket;
    private BufferedReader leggi;
    private PrintWriter scrivi;

    public Client (String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start () throws IOException {
        //creare un canale con il server
        socket = new Socket(host, port);
        //definire gli stream per leggere e scrivere (in questo caso il client comunica tramite testo)
        leggi = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        scrivi = new PrintWriter(socket.getOutputStream(), true);
    }

    public String leggi () throws IOException {
        return leggi.readLine();
    }

    public void scrivi (String sms) {
        scrivi.println(sms);
    }

    public void close () throws IOException {
        //chiudo tutti gli stream
        leggi.close();
        scrivi.close();
        socket.close();
    }
}
