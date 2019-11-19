package Server.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Server.Domain.Property;
import Server.Domain.User;

public class Database{
    public Connection getConn() throws ClassNotFoundException, SQLException{
        Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/Youup/Documents/GitHub/ENSF480-Final-Project/src/Server/Database.db");
        return c;
    }

    public boolean addProperty(Property p){
    	boolean success = true;
    	Connection conn = null;
    	PreparedStatement addProperty = null;
    	String addPropertyString = "INSERT INTO Property values (?, ?, ?, ? ,? ,?, ?, ?)";
    	try {
    		conn = getConn();
    		if(conn != null) {
    			addProperty = conn.prepareStatement(addPropertyString);
    			addProperty.setInt(1, p.getID());
    			addProperty.setString(2, p.getType());
    			addProperty.setInt(3, p.getNumOfBedrooms());
    			addProperty.setInt(4, p.getNumOfBathrooms());
    			addProperty.setBoolean(5, p.isFurnished());
    			addProperty.setString(6, p.getCityQuadrant());
    			addProperty.setString(7, p.getListingState());
    			addProperty.setDouble(8, p.getFee().getAmount());
    			addProperty.executeUpdate();
    			System.out.println("Added property");
    		}
    		conn.close();
    	} catch(ClassNotFoundException | SQLException e) {
    		e.printStackTrace();
    		return false;
    	}
    	return success;
    }

    public boolean removeProperty(Property p){
    	Connection conn = null;
    	PreparedStatement deleteProperty = null;
    	String deletePropertyString = "DELETE FROM Property WHERE ID = ?";
    	try {
    		conn = getConn();
    		if(conn != null) {
    			deleteProperty = conn.prepareStatement(deletePropertyString);
    			deleteProperty.setInt(1, p.getID());
    			deleteProperty.executeUpdate();
    			conn.close();
    			return true;
    		}
    		conn.close();
    	} catch(ClassNotFoundException | SQLException e) {
    		e.printStackTrace();
    	}
    	return false;
    }

    public ArrayList<Property> getProperties(){
        Connection conn = null;
        PreparedStatement getAllProperties = null;
        String getAllPropertiesString = "SELECT * from Property";
        ArrayList<Property> temp = new ArrayList<Property>();
        try {
        	conn = getConn();
        	if(conn != null) {
        		getAllProperties = conn.prepareStatement(getAllPropertiesString);
        		ResultSet rs = getAllProperties.executeQuery();
        		while(rs.next()) {
        			Property p = new Property(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
        					rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getDouble(8));
        			temp.add(p);
        		}
        		conn.close();
        		return temp;
        	}
        	conn.close();
        } catch(ClassNotFoundException | SQLException e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    
    public boolean addUser(User user){
    	
    }

    public void removeUser(User user){

    }

    public User validateLogin(String username, String password){
        
    }
}