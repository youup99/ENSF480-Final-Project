package Server.Domain;

import java.util.Random;

public class User{
	private int ID;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String type = "Regular";

    public User(String userName, String firstName, String lastName, String email, String type){
        this.ID = new Random().nextInt(1000000);
    	this.setUserName(userName);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
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
}