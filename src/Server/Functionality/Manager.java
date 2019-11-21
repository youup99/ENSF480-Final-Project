package Server.Domain;
public class Manager extends User{
    
    public Manager(String userName, String firstName, String lastName, String email, String password){
        super(userName, firstName, lastName, email, password, "Manager");
    }

    public void accessInfo(String query){

    }

    public void requestReport(){
        
    }
}