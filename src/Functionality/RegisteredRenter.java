package Functionality;

public class RegisteredRenter extends User {
	private static final long serialVersionUID = 1L;
	
    public PropertyListing propertiesInterested;

    public RegisteredRenter(String userName, String firstName, String lastName, String email, String password){
        super(userName, firstName, lastName, email, password, "Registered");
        propertiesInterested = new PropertyListing();
    }

    public void update(PropertyListing pl){
        propertiesInterested = pl;
    }

    public void sendListingEmail(){
        
    }

}