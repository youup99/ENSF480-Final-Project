package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import Client.Communication;
import Client.View.RenterMenuView;
import Client.View.RenterPropertyView;
import Functionality.Property;

public class GuestController implements GeneralRenterController, ActionListener
{
	private SearchController search;
	private RenterMenuView renterView;
	private PropertyController propertyC;
	private RenterPropertyView propView;
	
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
			if(searchResults == null)
				throw new NullPointerException();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[][] dataa = new String[searchResults.size()][6];
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
		propView = new RenterPropertyView(dataa);
		propView.setGuestController(this);
		propView.setDisplay(searchResults);
		propView.setVisible(true);
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
