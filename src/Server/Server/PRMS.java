package Server.Server;
import Server.Database.Database;
import Server.Domain.Customer;
import Server.Domain.Landlord;
import Server.Domain.Manager;
import Server.Domain.Property;
import Server.Domain.PropertyFee;
import Server.Domain.RegisteredRenter;
import Server.Domain.SummaryReport;
import Server.Domain.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
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