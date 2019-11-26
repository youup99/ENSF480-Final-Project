package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

import Functionality.Property;
import Functionality.PropertyFee;
import Functionality.SummaryReport;
import Functionality.User;

public class Communication{
	private ServerSocket serverSocket;
    private Socket socket;
    private ObjectInputStream socketIn;
    private ObjectOutputStream socketOut;
    private ExecutorService pool; //Not required...
    private static Communication onlyInstance;
    
    public static Communication getInstance ()
    {
    	if (onlyInstance == null)
    	{
			try 
			{
				System.out.println("TEST");
				onlyInstance = new Communication (new Socket ("localhost", 9090));
				System.out.println("TEST1");
			} catch (IOException e) 
			{
				System.err.println ("Error initialising Client Socket");
				e.printStackTrace();
			}
    	}
    	
    	return onlyInstance;
    }

    private Communication(Socket socket) throws IOException{
    	this.socket = socket;
        socketOut = new ObjectOutputStream(socket.getOutputStream());
        socketIn = new ObjectInputStream(socket.getInputStream());
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
    
    public Property getProperty() throws ClassNotFoundException, IOException{
    	Property property = (Property) socketIn.readObject();
    	return property;
    }
    
    public void sendProperty(Property property) throws IOException{
    	socketOut.reset();
    	socketOut.writeObject(property);
    	socketOut.flush();
    }
    
    public ArrayList<Property> getProperties() throws IOException, ClassNotFoundException{
    	@SuppressWarnings("unchecked")
		ArrayList<Property> properties = (ArrayList<Property>) socketIn.readObject();
    	return properties;
    }
    
    public void sendProperties(ArrayList<Property> properties) throws IOException{
    	socketOut.reset();
    	socketOut.writeObject(properties);
    	socketOut.flush();
    }
    
    public PropertyFee getPropertyFee() throws ClassNotFoundException, IOException{
    	PropertyFee fee = (PropertyFee) socketIn.readObject();
    	return fee;
    }
    
    public void sendPropertyFee(PropertyFee fee) throws IOException{
    	socketOut.reset();
    	socketOut.writeObject(fee);
    	socketOut.flush();
    }
    
    public User getUser() throws ClassNotFoundException, IOException{
    	User user = (User) socketIn.readObject();
    	return user;
    }
    
    public void sendUser(User user) throws IOException{
    	socketOut.reset();
    	socketOut.writeObject(user);
    	socketOut.flush();
    }
    
    public ArrayList<User> getUsers() throws IOException, ClassNotFoundException{
    	@SuppressWarnings("unchecked")
		ArrayList<User> users = (ArrayList<User>) socketIn.readObject();
    	return users;
    }
    
    public void sendUsers(ArrayList<User> users) throws IOException{
    	socketOut.reset();
    	socketOut.writeObject(users);
    	socketOut.flush();
    }
    
    public SummaryReport getReport(String start, String end) throws IOException, ClassNotFoundException{
    	SummaryReport report = (SummaryReport) socketIn.readObject();
    	return report;
    }
}