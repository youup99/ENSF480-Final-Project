package Server.Domain;
public class Manager extends User{
    
    public Manager(String userName, String firstName, String lastName, String email){
        super(userName, firstName, lastName, email, "Manager");
    }

    public void accessInfo(String query){

    }

    public void requestReport(){
        
    }
}