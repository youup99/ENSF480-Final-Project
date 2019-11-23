package Client.Client;

public class Client {
	public static void main(String[] args) {
		Customer customer = new Customer("localhost", 9090);
		System.out.println("Connected to server");
		customer.login();
	}
}
