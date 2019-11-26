package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import Client.Communication;
import Client.View.RenterMenuView;
import Functionality.Property;
import Functionality.RegisteredRenter;;

public class RenterController implements ActionListener, GeneralRenterController 
{
	private RenterMenuView renterView;
	private SearchController search;
	private RegisteredRenter renter;
	private PropertyController propertyC;
	
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
			System.exit(1);
		}
		
		search = new SearchController (this);
	}
	
	public void getSearchData (Property data)
	{
		ArrayList<Property> searchResults = null;
		
		Communication cToS = Communication.getInstance();
		try {
			cToS.sendString("preferences"); //TODO: will change, only temporary
			cToS.sendUser(renter);
			cToS.sendProperty(data); //preferences
			
			//Displaying search results:
			cToS.sendString("get properties");
			cToS.sendProperty(data);
			searchResults = cToS.getProperties();
			if (searchResults == null)
				throw new NullPointerException();
			
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (NullPointerException e1)
		{
			System.out.println("getProperties() did not retrieve data - returned null to searchResult");
			e1.printStackTrace();
		}
		propertyC = new PropertyController ();
		propertyC.displayProperties("renter", searchResults);
		renterView.setVisible(true);
	}

}