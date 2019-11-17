public class Landlord extends User{

    public ArrayList<Property> ownedProperties;

    public Landlord(String userName, String firstName, String lastName, String email, ArrayList<Property> properties){
        super(userName, firstName, lastName, email);
        ownedProperties = properties;
    }
}