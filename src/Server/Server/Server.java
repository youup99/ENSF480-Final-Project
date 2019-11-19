package Server.Server;

import java.io.IOException;

public class Server {
	public static void main(String[] args) throws IOException{
		PRMS prms = new PRMS();
		System.out.println("Server is running");
		prms.start();
	}
}
