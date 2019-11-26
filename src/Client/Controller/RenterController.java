package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import Client.Communication;
import Client.View.LandlordPropertyView;
import Client.View.RenterMenuView;
import Client.View.RenterPropertyView;
import Functionality.Property;
import Functionality.RegisteredRenter;;

public class RenterController implements ActionListener, GeneralRenterController 
{
	private RenterMenuView renterView;
	private SearchController search;
	private RegisteredRenter renter;
	private PropertyController propertyC;
	private RenterPropertyView propView;
	private ArrayList<Property> searchResults = null;
	private String[][] dataa;
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
		
		setData();
			
		propView = new RenterPropertyView(dataa);
		propView.setRenterController(this);
		propView.setDisplay(searchResults);
		propView.setVisible(true);
	}
	
	public void setData() {
		dataa = new String[searchResults.size()][6];
		for(int i = 0; i < searchResults.size(); i++) {
			   for(int j = 0; j < 6; j++) {
				    if (j == 0) {
					   dataa[i][j] = Integer.toString(searchResults.get(i).getID());
	       			} else if (j == 1) {
	       			   dataa[i][j] = searchResults.get(i).getType();
	       		    } else if (j == 2) {
	       			   dataa[i][j] = Integer.toString(searchResults.get(i).getNumOfBedrooms());
	       		    } else if (j == 3) {
	       			   dataa[i][j] = Integer.toString(searchResults.get(i).getNumOfBathrooms());
	       		    } else if (j == 4) {
	       			   if (searchResults.get(i).isFurnished() == true) {
	       				   dataa[i][j] = "Yes";
	       			   } else if (searchResults.get(i).isFurnished() == false) {
	       				   dataa[i][j] = "No";
	       			   }
	       		    } else if (j == 5) {
	       			   dataa[i][j] = searchResults.get(i).getCityQuadrant();
	       		    }
	       	   }
	       }
	}
}