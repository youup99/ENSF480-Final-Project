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
    
    public ArrayList<Property> getProperties() throws IOException{
    	return db.getProperties();
    }

    // TODO: GETTERS, ADDERS, DELETERS for Property and User
}