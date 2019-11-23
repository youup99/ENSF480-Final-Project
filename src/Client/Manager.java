package Client;
public class Manager extends User{
	private static final long serialVersionUID = 1L;

    public Manager(String userName, String firstName, String lastName, String email, String password){
        super(userName, firstName, lastName, email, password, "Manager");
    }

    public void accessInfo(String query){

    }

    public void requestReport(){
        
    }
}