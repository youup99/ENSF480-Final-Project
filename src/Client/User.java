package Client;

import java.io.Serializable;
import java.util.Random;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private int ID;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String type = "Registered";

    public User(String userName, String firstName, String lastName, String email, String password, String type){
        this.ID = new Random().nextInt(1000000);
    	this.setUserName(userName);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setPassword(password);
        this.setType(type);
    }

	public User(int ID, String userName, String firstName, String lastName, String email, String password, String type){
        this.ID = ID;
    	this.setUserName(userName);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setPassword(password);
        this.setType(type);
    }

	public int getID() {
		return ID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}