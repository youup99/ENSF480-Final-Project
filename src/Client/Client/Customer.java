package Client.Client;

import java.io.IOException;
import java.net.Socket;

import Client.Controller.LoginController;
import Client.Controller.MainController;
import Client.View.LoginView;
import Server.Domain.Communication;

public class Customer {
	Communication communicator;
	
	public Customer(String serverName, int portNumber) {
		try {
			communicator = new Communication(new Socket(serverName, portNumber));
		} catch(IOException e) {
			System.err.println(e.getStackTrace());
		}
	}
	
	public void start() {
		MainController mc = new MainController();

	}
}
