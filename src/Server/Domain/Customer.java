package Server.Domain;
import Server.Database.Database;
import java.io.IOException;
import java.net.Socket;

public class Customer implements Runnable{
    Communication communicator;
    Operations operations;

    public Customer(Socket aSocket, Database db){
        try{
            communicator = new Communication(aSocket);
            operations = new Operations(db);
        } catch (IOException e){
            System.err.println(e.getStackTrace());
        }
    }

    @Override
    public void run(){
        try{
            this.loop();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loop() throws IOException{
        Boolean run = true;
        while(run){
            String op = "";
            try{
                op = communicator.getString();
            } catch (ClassNotFoundException | IOException e){
                e.printStackTrace();
            }


            if(op.contentEquals("")){
                System.err.println("User failed to get opString");
                run = false;
                break;
            }
            
            switch(op){
            	case("add property"): {
            		String success;
            		try {
            			
            		} catch(Exception e) {
            			e.printStackTrace();
            		}
            	}
            }
        }
    }

}