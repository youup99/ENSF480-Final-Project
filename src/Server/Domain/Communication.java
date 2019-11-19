package Server.Domain;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class Communication{
    private ServerSocket serverSocket;
    private Socket aSocket;
    private ObjectInputStream socketIn;
    private ObjectOutputStream socketOut;
    private ExecutorService pool;

    Communication(Socket socket) throws IOException{
        this.aSocket = socket;
        socketIn = new ObjectInputStream(aSocket.getInputStream());
        socketOut = new ObjectOutputStream(aSocket.getOutputStream());
    }

    public void sendString(String s) throws IOException{
        socketOut.reset();
        socketOut.writeObject(s);
        socketOut.flush();
    }

    public String getString() throws ClassNotFoundException, IOException{
        String s = (String) socketIn.readObject();
        return s;
    }

    // TODO: GETTERS, ADDERS FOR PROPERTY and USER
}