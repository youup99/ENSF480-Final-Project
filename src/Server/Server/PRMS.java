package Server.Server;
import Server.Database.Database;
import Server.Domain.Customer;
import Server.Domain.Property;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PRMS{
    ServerSocket serverSocket;

    public PRMS() throws IOException{
        serverSocket = new ServerSocket(9090);
    }

    public void start(){
        ExecutorService es = Executors.newFixedThreadPool(5);
        Database db = new Database();
//        Property p = new Property("House", 3, 3, true, "NW", "Active", 100);
//        db.addProperty(p);
//        Property temp = new Property(103565, "House", 3, 3, true, "NW", "Active", 100);
//        db.removeProperty(temp);
//        ArrayList<Property> temp = db.getProperties();
//        for(Property p : temp) {
//        	System.out.println(p.getID());
//        }
        try{
            while(true){
                synchronized(db){
                    Socket aSocket = serverSocket.accept();
                    Customer customer = new Customer(aSocket, db);
                    es.execute(customer);
                }
            }
        } catch(IOException e){
            System.err.println("PRMS Crashed");
            e.printStackTrace();
        }
    }
}