package Server.Domain;
public class RegisteredRenter extends User{

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