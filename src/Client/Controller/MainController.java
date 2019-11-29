package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Client.Communication;
import Client.View.MainView;

public class MainController implements ActionListener
{
    private MainView mainView;
    private Communication clientToServer; //TODO: Link depending on where Main for Client should go...
    
    private LoginController login;
    private SearchController searchController;
    
    public MainController ()
    {
    	clientToServer = Communication.getInstance();
    	mainView = new MainView ();
    	this.addListenersToView();
    	mainView.setVisible(true);
    }

    public void addListenersToView()
    {
        mainView.addLandlordListener(this);
        mainView.addRenterListener(this);
        mainView.addManagerListener(this);
        mainView.addGuestListener(this);
    }
    
    public static void main (String[] args)
    {
    	MainController controller = new MainController ();
    }

    @Override
	public void actionPerformed (ActionEvent e) 
	{
		if (e.getActionCommand().equals("guest"))
		{
			mainView.setVisible(false);
			GuestController guests = new GuestController (); //Unregistered can search...
		}
		else if(e.getActionCommand().contentEquals("Landlord"))
		{
			mainView.setVisible(false);
			login = new LoginController (e.getActionCommand()); //Make mainview invisible and display login screen
		}
		else if(e.getActionCommand().contentEquals("Registered"))
		{
			mainView.setVisible(false);
			login = new LoginController (e.getActionCommand());
		}
		else if(e.getActionCommand().contentEquals("Manager"))
		{
			mainView.setVisible(false);
			login = new LoginController (e.getActionCommand());
		}
	}
}
