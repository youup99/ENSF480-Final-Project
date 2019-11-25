package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Client.Communication;
import Client.Property;
import Client.RegisteredRenter;
import Client.View.RenterMenuView;;

public class RenterController implements ActionListener, GeneralRenterController 
{
	private RenterMenuView renterView;
	private SearchController search;
	private RegisteredRenter renter;
	
	public RenterController (RegisteredRenter renter)
	{
		renterView = new RenterMenuView ();
		renterView.setVisible(true);
		addListenersToClass();
		this.renter = renter;
	}
	
	private void addListenersToClass ()
	{
		renterView.addSearchListener (this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand().equals("exit"))
		{
			renterView.setVisible(false);
			return;
		}
		
		search = new SearchController (this);
	}
	
	public void getSearchData (Property data)
	{
		Communication cToS = Communication.getInstance();
		try {
			cToS.sendString("preferences"); //TODO: will change, only temporary
			cToS.sendString(renter.getFirstName() + " " + renter.getLastName());
			cToS.sendProperty(data); //preferences
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		renterView.setVisible(true);
	}

}
//tricking
