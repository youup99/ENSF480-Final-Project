package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Client.Communication;
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
		String password = loginView.getPassword();
		
		System.out.println (username + "was Username and Password is " + password);
		this.openHomePage();
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
					openHomePage();
				}
			}
			else 
			{
				cToS.sendString("register");
				cToS.sendString(username);
				cToS.sendString(password);
				
				this.openHomePage();
			}
		}
		catch (IOException | ClassNotFoundException e2)
		{
			e2.printStackTrace();
		}
	}

	private void openHomePage() 
	{
		switch (userType)
		{
		case "renter":
			RenterController renter = new RenterController ();
			break;
		case "landlord":
			LandlordController landlord = new LandlordController ();
			break;
		case "manager":
			ManagerController manager = new ManagerController ();
			break;	
		}
		
		loginView.setVisible(false);		
	}
}
