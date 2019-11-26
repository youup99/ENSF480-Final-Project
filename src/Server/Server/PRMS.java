package Server.Server;
import Server.Database.Database;
import Server.Domain.Customer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Functionality.User;

public class PRMS{
    ServerSocket serverSocket;

    public PRMS() throws IOException{
        serverSocket = new ServerSocket(9090);
    }

    public void start(){
        ExecutorService es = Executors.newFixedThreadPool(5);
        Database db = new Database();
//        User u = new User("youup99", "David", "Kim", "youup99@gmail.com", "990926", "Registered");
//        db.addUser(u);
        try{
            while(true){
                synchronized(db){
                    Socket aSocket = serverSocket.accept();
                    Customer customer = new Customer(aSocket, db);
                	System.out.println("HI");
                    es.execute(customer);
                }
            }
        } catch(IOException e){
            System.err.println("PRMS Crashed");
            e.printStackTrace();
        }
    }
}