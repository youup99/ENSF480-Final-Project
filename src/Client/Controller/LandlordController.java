package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
	private ArrayList<Property> landlordProperties = new ArrayList<Property>();
	String[][] data;

	
	public LandlordController (Landlord l)
	{
		landlordView = new LandlordMenuView ();
		landlordView.setVisible(true);
		landlord = l;
		propertyC = new PropertyController ();
		this.addActionListeners();
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
		landlordView.addExitListener(this);
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
			System.exit(1);
		}
	}
	
	private void getLandlordProperties ()
	{
		Communication ctos = Communication.getInstance();
		try {
			ctos.sendString("landlord properties");
			ctos.sendString (landlord.getFirstName() + " " + landlord.getLastName());
			landlordProperties = ctos.getProperties(); //TODO: IMPLEMENT GETPROPERTIES
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}		
		//ownedProperties = landlordProperties;
		setData();
		propView = new LandlordPropertyView(data, landlordProperties);
		propView.setLandlordController(this);
		//propView.setDisplay(landlordProperties); //This is no longer required either
	}
	
	public void setData() {
		data = new String[landlordProperties.size()][6];
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
	}
	
	public void updateStatus (Property p)
	{
		Communication c = Communication.getInstance();
		try {
			c.sendString("change state");
			c.sendString (p.getListingState());
			c.sendString(Integer.toString(p.getID()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addNewProperty() 
	{
			
		if (newProp.getCardNum().length() != 16) {
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, "Wrong card number! Try again.", "Alert", JOptionPane.WARNING_MESSAGE);		
		} else if (newProp.getCvv().length() != 3) {
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, "Wrong CVV number! Try again.", "Alert", JOptionPane.WARNING_MESSAGE);
		} else {
			newProp.setVisible(false);
			String name = landlord.getFirstName() + " " + landlord.getLastName();
			Property property = new Property (newProp.getAddress(), newProp.getTypes(), newProp.getBed(), //TODO WHERE is address from
			newProp.getBath(), newProp.getFurnished(),
			newProp.getCity(), name, landlord.getEmail());
			propertyC.addNewProperty(property);
		}
		
	}

}
