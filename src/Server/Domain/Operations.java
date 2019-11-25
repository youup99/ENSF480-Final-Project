package Server.Domain;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import Server.Database.Database;

public class Operations{
    private Database db;

    public Operations(Database db){
        this.db = db;
    }
    
    public String addProperty(Property p) throws IOException{
    	if(db.addProperty(p)) {
    		return "Success!";
    	} else {
    		return "Unsuccessful!";
    	}
    }
    
    public String removeProperty(Property p) throws IOException, SQLException{
    	if(p != null) {
    		if(db.removeProperty(p)) {
    			return "Success!";
    		} else {
    			return "Unsuccessful!";
    		}
    	}
    	return "Unsuccessful!";
    }
    
    public Property getProperty(int ID) throws IOException, SQLException {
    	return db.getProperty(ID);
    }
    
    public ArrayList<Property> getAllProperties() throws IOException{
    	return db.getAllProperties();
    }
    
    public ArrayList<Property> getProperties(Property p) throws IOException{
    	return db.getProperties(p);
    }
    
    public ArrayList<Property> getLandlordProperties(String name) throws IOException{
    	return db.getLandlordProperties(name);
    }
    
    public String changeState(String newState, int ID) throws IOException{
    	if(db.changeState(newState, ID)) {
    		return "Success!";
    	} else {
    		return "Unsuccessful!";
    	}
    }
    
    public String addUser(User u) throws IOException{
    	if(db.addUser(u)) {
    		return "Success!";
    	} else {
    		return "Unsuccessful!";
    	}
    }
    
    public String removeUser(User u) throws IOException, SQLException{
    	if(u != null) {
    		if(db.removeUser(u)) {
    			return "Success!";
    		} else {
    			return "Unsuccessful!";
    		}
    	}
    	return "Unsuccessful!";
    }
    
    public User getUser(String userName) throws IOException, SQLException {
    	return db.getUser(userName);
    }
    
    public ArrayList<User> getUsers() throws IOException{
    	return db.getUsers();
    }
    
    public String updateFee(PropertyFee fee) throws IOException{
    	if(db.updateFee(fee)) {
    		return "Success!";
    	} else {
    		return "Unsuccessful!";
    	}
    }
    
    public SummaryReport getReport(String start, String end) throws IOException{
    	return db.getReport(start, end);
    }
    
    public User login(String username, String password) throws IOException{
    	return db.login(username, password);
    }

}