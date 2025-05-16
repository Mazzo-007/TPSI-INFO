package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static String host = "localhost"; //l'indirizzo IP del server
    public static int port = 12345; //il numero di porta del server in cui è in ascolto il programma

    public static void main(String[] args) throws IOException {
        String sms, risposta; //contiene il messaggio da inviare al server e la sua risposta

        //creare un canale con il server
        Socket socket = new Socket(host, port);

        //definire gli stream per leggere e scrivere (in questo caso il client comunica tramite testo)
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

        //stream per leggere da input
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Scrivi un messaggio da inviare al server ('exit termino la connesione):");
        while (!(sms = tastiera.readLine()).equalsIgnoreCase("exit")) {
            //spedisco il messaggio dell'utente
            pw.println(sms);
            risposta = br.readLine();
            System.out.println("Risposta del server: " + risposta);
        }

        //chiudo tutti gli stream
        br.close();
        pw.close();
        socket.close();
    }
}