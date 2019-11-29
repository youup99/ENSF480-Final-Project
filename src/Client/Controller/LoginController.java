package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Client.Communication;
import Client.View.LoginView;
import Client.View.NewUserView;
import Functionality.Landlord;
import Functionality.Manager;
import Functionality.RegisteredRenter;
import Functionality.User;

public class LoginController implements ActionListener
{
    private LoginView loginView;
    private NewUserView newUserView;
    private String userType;
    
    public LoginController (String userType)
    {
    	this.userType = userType;
    	loginView = new LoginView ();
        loginView.setVisible(true);
        this.addListenersToView();
    }

    public void addListenersToView()
    {
        loginView.addLoginListener (this);
        loginView.addNewListener (this);
    }

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String username = loginView.getUsername();
		String password = loginView.getPassword();
		Communication cToS = Communication.getInstance();
		
		try
		{
			if (e.getActionCommand().equals("login"))
			{				
				cToS.sendString("login");
				cToS.sendString(username);
				cToS.sendString(password);
				cToS.sendString(userType);
				
				User returnedData = cToS.getUser(); //Use somewhere if possible
				
				if (returnedData == null) 
				{
					//deal with invalid login case.
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Incorrect username or password", "Alert", JOptionPane.WARNING_MESSAGE);		
				}
				else
				{
					openHomePage(returnedData);
				}
			}
			else if (e.getActionCommand().equals("register"))
			{
				newUserView = new NewUserView ();
				newUserView.setVisible(true);
				return;
			}
			else if (e.getActionCommand().equals("submit"))
			{
				cToS.sendString("add user");
				User user = new User (newUserView.getuName(), newUserView.getfName(), newUserView.getlName(),
						newUserView.getEmail(), newUserView.getPassword(), "Registered");
				cToS.sendUser(user);
				this.openHomePage(user);
			}
		}
		catch (IOException | ClassNotFoundException e2)
		{
			e2.printStackTrace();
		}
	}

	private void openHomePage(User data) 
	{
		switch (userType)
		{
		case "Registered":
			RenterController renter = new RenterController (new RegisteredRenter (data.getUserName(), data.getFirstName(),
					data.getLastName(), data.getEmail(), data.getPassword()));
			break;
		case "Landlord":
			LandlordController landlord = new LandlordController (new Landlord (data.getUserName()
					, data.getFirstName(), data.getLastName(), data.getEmail(), data.getPassword()));
			break;
		case "Manager":
			ManagerController manager = new ManagerController (new Manager (data.getUserName()
					, data.getFirstName(), data.getLastName(), data.getEmail(), data.getPassword()));
			break;	
		}
		
		loginView.setVisible(false);		
	}
}