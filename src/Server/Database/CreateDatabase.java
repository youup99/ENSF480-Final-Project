package Server.Database;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.DriverManager;


public class CreateDatabase{
    public static void createNewDatabase(){
        String url = "jdbc:sqlite:C:/Users/Youup/Documents/GitHub/ENSF480-Final-Project/src/Server/Database.db" ;
        try(Connection conn = DriverManager.getConnection(url)){
            if(conn != null){
                conn.setAutoCommit(false);
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                addPropertyData(conn);
                addUserData(conn);
                conn.close();
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void addPropertyData(Connection c){
        java.sql.Statement stmt = null;
        try{
            stmt = c.createStatement();
            String sql = "CREATE TABLE Property " + "(ID INT PRIMARY KEY	NOT NULL," + " type TEXT     NOT NULL," + " numOfBedrooms INT    NOT NULL," + 
            " numOfBathrooms INT    NOT NULL," + " isFurnished BOOLEAN      NOT NULL," + " cityQuadrant TEXT    NOT NULL," + 
            " listingState TEXT     NOT NULL," + "fee REAL      NOT NULL);";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
        } catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    public static void addUserData(Connection c){
        java.sql.Statement stmt = null;
        try{
            stmt = c.createStatement();
            String sql = "CREATE TABLE User " + "(ID INT PRIMARY KEY	NOT NULL," + " type TEXT     NOT NULL," + " userName TEXT    NOT NULL," + 
            " firstName TEXT    NOT NULL," + " lastName TEXT      NOT NULL," + " email TEXT    NOT NULL);";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
        } catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    public static void main(String[] args){
        createNewDatabase();
    }
}