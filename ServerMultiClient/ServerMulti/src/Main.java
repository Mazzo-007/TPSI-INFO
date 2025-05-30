import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static final int port = 12345;
    public static GestoreRoom gr;
    public static void main(String[] args) throws IOException, InterruptedException {
        gr = new GestoreRoom();
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Server up");
        while(true){
            Socket client = ss.accept();//restituisce un oggetto Socket verso il client
            System.out.println("Accetto il client");
            gr.getRoom("INFO").addClient(client);
        }
    }
}