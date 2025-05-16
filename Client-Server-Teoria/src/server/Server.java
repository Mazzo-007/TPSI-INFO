package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Server {
    private int port; //il numero di porta del server in cui è in ascolto
    private ServerSocket ss;
    private Socket client;
    private BufferedReader leggi;
    private PrintWriter scrivi;
    private String client_sms;

    public Server(int port) {
        this.port = port;
    }

    public void start () throws IOException {
        //creare un canale in ascolto con il client sulla porta selezionata
        ss = new ServerSocket(port);
        //crea il canale di comunicazione verso il client
        client = ss.accept();
        leggi = new BufferedReader(new InputStreamReader(client.getInputStream()));
        scrivi = new PrintWriter(new PrintWriter(client.getOutputStream(), true));
    }

    private String leggi () throws IOException {
        client_sms = leggi.readLine();
        return client_sms;
    }

    private void scrivi (String sms) {
        scrivi.println(sms);
    }

    public void close () throws IOException {
        //chiudo tutti gli stream
        leggi.close();
        scrivi.close();
        client.close();
        ss.close();
    }
}
