import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;

public class Communication{
    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectInputStream socketIn;
    private ObjectOutputStream socketOut;
    private ExecutorService pool;

    private Communication(){
        
    }
    public void communicateClient(){

    }
}