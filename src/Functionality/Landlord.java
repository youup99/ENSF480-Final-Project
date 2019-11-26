package Functionality;

public class Landlord extends User{
	private static final long serialVersionUID = 1L;


    public Landlord(String userName, String firstName, String lastName, String email, String password){
        super(userName, firstName, lastName, email, password, "Landlord");
    }
}