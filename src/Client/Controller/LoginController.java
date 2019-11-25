package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Client.Communication;
import Client.Landlord;
import Client.RegisteredRenter;
import Client.User;
import Client.View.LoginView;
import Client.View.NewUserView;

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
		String password = loginView.getPassword().toString();
		Communication cToS = Communication.getInstance();
		
		try
		{
			if (e.getActionCommand().equals("login"))
			{				
				cToS.sendString("login");
				cToS.sendString(username);
				cToS.sendString(password);	
				
				User returnedData = cToS.getUser(); //Use somewhere if possible
				
				if (returnedData == null) 
				{
					//deal with invalid login case.
					
					return;
				}
				else
				{
					openHomePage(returnedData);
				}
			}
			else if (e.getActionCommand().equals("register"))
			{
				//cToS.sendString("register");
				newUserView = new NewUserView ();
				newUserView.setVisible(true);
				return;
			}
			else if (e.getActionCommand().equals("submit"))
			{
				cToS.sendString("register");
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
		case "renter":
			RenterController renter = new RenterController (new RegisteredRenter (data.getUserName(), data.getFirstName(),
					data.getLastName(), data.getEmail(), data.getPassword()));
			break;
		case "landlord":
			LandlordController landlord = new LandlordController (new Landlord (data.getUserName()
					, data.getFirstName(), data.getLastName(), data.getEmail(), data.getPassword(), null));
			break;
		case "manager":
			ManagerController manager = new ManagerController ();
			break;	
		}
		
		loginView.setVisible(false);		
	}
}

//TRICK