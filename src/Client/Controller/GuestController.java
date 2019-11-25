package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import Client.Communication;
import Client.Property;
import Client.View.RenterMenuView;

public class GuestController implements GeneralRenterController, ActionListener
{
	private SearchController search;
	private RenterMenuView renterView;
	private PropertyController propertyC;
	
	public GuestController ()
	{
		renterView = new RenterMenuView ();
		renterView.setVisible(true);
		addListenersToClass();
	}

	private void addListenersToClass ()
	{
		renterView.addSearchListener (this);
	}

	@Override
	public void getSearchData(Property p) 
	{
		ArrayList<Property> searchResults = null;
		Communication ctos = Communication.getInstance();
		try {
			ctos.sendString("get properties");
			ctos.sendProperty(p);
			searchResults = ctos.getProperties();
			propertyC.displayProperties("renter", searchResults); //TODO: See whether there's a guest usertype check.
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		renterView.setVisible(true);
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

}
