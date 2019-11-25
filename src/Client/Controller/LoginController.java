package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Client.Communication;
import Client.Landlord;
import Client.User;
import Client.View.LoginView;

public class LoginController implements ActionListener
{
    private LoginView loginView;
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
					openHomePage(username, password);
				}
			}
			else 
			{
				cToS.sendString("register");
				cToS.sendString(username);
				cToS.sendString(password);
				
				this.openHomePage(username, password);
			}
		}
		catch (IOException | ClassNotFoundException e2)
		{
			e2.printStackTrace();
		}
	}

	private void openHomePage(String username, String password) 
	{
		switch (userType)
		{
		case "renter":
			RenterController renter = new RenterController ();
			break;
		case "landlord":
			LandlordController landlord = new LandlordController (new Landlord (username, null, null, null, password, null));
			break;
		case "manager":
			ManagerController manager = new ManagerController ();
			break;	
		}
		
		loginView.setVisible(false);		
	}
}
