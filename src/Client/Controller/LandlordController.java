package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import Client.Communication;
import Client.View.CreatePropertyView;
import Client.View.LandlordMenuView;
import Client.View.LandlordPropertyView;
import Functionality.Landlord;
import Functionality.Property;
import Functionality.PropertyFee;


public class LandlordController implements ActionListener 
{
	private Landlord landlord;
	private LandlordMenuView landlordView;
	private CreatePropertyView newProp;
	private LandlordPropertyView propView;
	private PropertyController propertyC;
	private ArrayList<Property> ownedProperties;
	
	public LandlordController (Landlord l)
	{
		landlordView = new LandlordMenuView ();
		landlordView.setVisible(true);
		landlord = l;
		propertyC = new PropertyController ();
		this.addActionListeners();
		ownedProperties = new ArrayList<Property> ();
	}
	
	private void addProperty ()
	{
		PropertyFee propertyFee = new PropertyFee();
		newProp = new CreatePropertyView ();
		newProp.setCurrentFee(propertyFee.getAmount()); //TODO view needs to display the fee paid...
		newProp.setVisible(true); //No need for previous one to be invisible
		
		
		newProp.addSubmitListener(this);
	}
	
	private void addActionListeners ()
	{
		//landlordView.addFeeListener(this);
		landlordView.addEditListener(this);
		landlordView.addCreateListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch (e.getActionCommand())
		{
		case "create property":
			this.addProperty();
			break;
		case "edit property":
			this.getLandlordProperties();
			//display property, allow landlord to select one.
			
			break;
		case "addSubmit": //For add property
			addNewProperty();
			break;
		case "exit":
			landlordView.setVisible(false);
			break;
		}
	}
	
	private void getLandlordProperties ()
	{
		Communication ctos = Communication.getInstance();
		ArrayList<Property> landlordProperties = new ArrayList<Property>();
		try {
			ctos.sendString("landlord properties");
			ctos.sendString (landlord.getFirstName() + " " + landlord.getLastName());
			landlordProperties = ctos.getProperties(); //TODO: IMPLEMENT GETPROPERTIES
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}		
		ownedProperties = landlordProperties;
		String[][] data = new String[landlordProperties.size()][6];
		for(int i = 0; i < landlordProperties.size(); i++) {
			   for(int j = 0; j < 6; j++) {
				    if (j == 0) {
					   data[i][j] = Integer.toString(landlordProperties.get(i).getID());
	       			} else if (j == 1) {
	       			   data[i][j] = landlordProperties.get(i).getType();
	       		    } else if (j == 2) {
	       			   data[i][j] = Integer.toString(landlordProperties.get(i).getNumOfBedrooms());
	       		    } else if (j == 3) {
	       			   data[i][j] = Integer.toString(landlordProperties.get(i).getNumOfBathrooms());
	       		    } else if (j == 4) {
	       			   if (landlordProperties.get(i).isFurnished() == true) {
	       				   data[i][j] = "Yes";
	       			   } else if (landlordProperties.get(i).isFurnished() == false) {
	       				   data[i][j] = "No";
	       			   }
	       		    } else if (j == 5) {
	       			   data[i][j] = landlordProperties.get(i).getCityQuadrant();
	       		    }
	       	   }
	       }		
		propView = new LandlordPropertyView(data);
		propView.setLandlordController(this);
		propView.setDisplay(ownedProperties);
	}
	
	public void updateStatus (Property p)
	{
		Communication c = Communication.getInstance();
		try {
			c.sendString("change state");
			c.sendString (p.getListingState());
			c.sendString(Integer.toString(p.getID()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addNewProperty() 
	{
		newProp.setVisible(false);
		Property property = new Property (newProp.getAddress(), newProp.getTypes(), newProp.getBed(), //TODO WHERE is address from
				newProp.getBath(), newProp.getFurnished(),
				newProp.getCity(), landlord.getUserName(), landlord.getEmail());
		
		
		propertyC.addNewProperty(property);
	}

}
