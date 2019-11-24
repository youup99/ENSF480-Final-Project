package Server.Domain;

import Server.Database.Database;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class Customer implements Runnable {
    Communication communicator;
    Operations operations;

	public Customer(Socket aSocket, Database db) {
		try {
			communicator = new Communication(aSocket);
			operations = new Operations(db);
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}

	@Override
	public void run() {
		try {
			this.loop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loop() throws IOException{
        Boolean run = true;
        while(run){
            String op = "";
            try{
                op = communicator.getString();
            } catch (ClassNotFoundException | IOException e){
                e.printStackTrace();
            }


            if(op.contentEquals("")){
                System.err.println("User failed to get opString");
                run = false;
                break;
            }
            
            switch(op){
            	case("add property"): {
            		String success;
            		try {
            			Property temp = communicator.getProperty();
            			success = operations.addProperty(temp);
            			if(success.contentEquals("Success!")) {
            				communicator.sendString("added");
            				communicator.sendProperty(temp);
            			}
            			else {
            				communicator.sendString("Error adding property");
            			}
            		} catch(ClassNotFoundException e) {
            			e.printStackTrace();
            		}
            		break;
            	}
            	case("remove property"): {
            		String success;
            		try {
            			Property temp = communicator.getProperty();
            			success = operations.removeProperty(temp);
            			if(success.contentEquals("Success!")) {
            				communicator.sendString("removed");
            				communicator.sendProperty(temp);
            			}
            			else {
            				communicator.sendString("Error removing property");
            			}
            		} catch(ClassNotFoundException e) {
            			e.printStackTrace();
            		} catch(SQLException e) {
            			e.printStackTrace();
            		}
            		break;
            	}
            	case("get property"): {
            		try {
            			int ID = Integer.parseInt(communicator.getString());
            			Property p = operations.getProperty(ID);
            			if(p != null) {
            				communicator.sendString("found");
            				communicator.sendProperty(p);
            			}
            			else {
            				communicator.sendString("Could not find property");
            			}
            		} catch(ClassNotFoundException e) {
            			e.printStackTrace();
            		} catch(SQLException e) {
            			e.printStackTrace();
            		}
            		break;
            	}
            	case("get properties"): {
            		try {
            			Property searchCriteria = communicator.getProperty();
            			ArrayList<Property> properties = operations.getProperties(searchCriteria);
            			if(properties != null) {
            				communicator.sendProperties(properties);
            			}
            			else {
            				communicator.sendString("Could not find properties");
            			}
            		} catch(ClassNotFoundException e) {
            			e.printStackTrace();
            		}
            		break;
            	}
            	case("change state"): {
            		String success;
            		try {
            			String newState = communicator.getString();
            			int ID = Integer.parseInt(communicator.getString());
            			success = operations.changeState(newState, ID);
            			if(success.contentEquals("Success!")) {
            				communicator.sendString("changed state");
            			}
            			else {
            				communicator.sendString("Error changing state");
            			}
            		} catch(ClassNotFoundException e) {
            			e.printStackTrace();
            		}
            		break;
            	}
            	case("add user"): {
            		String success;
            		try {
            			User temp = communicator.getUser();
            			success = operations.addUser(temp);
            			if(success.contentEquals("Success!")) {
            				communicator.sendString("added");
            				communicator.sendUser(temp);
            			}
            			else {
            				communicator.sendString("Error adding user");
            			}
            		} catch(ClassNotFoundException e) {
            			e.printStackTrace();
            		}
            		break;
            	}
            	case("remove user"): {
            		String success;
            		try {
            			User temp = communicator.getUser();
            			success = operations.removeUser(temp);
            			if(success.contentEquals("Success!")) {
            				communicator.sendString("removed");
            				communicator.sendUser(temp);
            			}
            			else {
            				communicator.sendString("Error removing property");
            			}
            		} catch(ClassNotFoundException e) {
            			e.printStackTrace();
            		} catch(SQLException e) {
            			e.printStackTrace();
            		}
            		break;
            	}
            	case("get user"): {
            		try {
            			String userName = communicator.getString();
            			User u = operations.getUser(userName);
            			if(u != null) {
            				communicator.sendString("found");
            				communicator.sendUser(u);
            			}
            			else {
            				communicator.sendString("Could not find user");
            			}
            		} catch(ClassNotFoundException e) {
            			e.printStackTrace();
            		} catch(SQLException e) {
            			e.printStackTrace();
            		}
            		break;
            	}
            	case("get users"): {
            		ArrayList<User> users = operations.getUsers();
					if(users != null) {
						communicator.sendUsers(users);
					}
					else {
						communicator.sendString("Could not find users");
					}
            		break;
            	}
            	case("update fee"): {
            		String success;
            		try {
            			PropertyFee fee = communicator.getPropertyFee();
            			success = operations.updateFee(fee);
            			if(success.contentEquals("Success!")) {
            				communicator.sendString("updated");
            				communicator.sendPropertyFee(fee);
            			}
            			else {
            				communicator.sendString("Error updating fee");
            			}
            		} catch(ClassNotFoundException e) {
            			e.printStackTrace();
            		}
            		break;
            	}
            	case("get report"): {
            		try {
            			Date start = communicator.getDate();
            			Date end = communicator.getDate();
            			SummaryReport report = operations.getReport(start, end);
            			if(report != null) {
            				communicator.sendReport(report);
            			} 
            			else {
            				communicator.sendString("Could not generate report");
            			}
            			break;
            		} catch(ClassNotFoundException e) {
            			e.printStackTrace();
            		}
            	}
            }
        }
    }

}