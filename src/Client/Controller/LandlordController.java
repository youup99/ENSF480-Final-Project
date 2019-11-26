package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import Client.Communication;
import Client.Landlord;
import Client.Property;
import Client.PropertyFee;
import Client.View.CreatePropertyView;
import Client.View.EditPropertyView;
import Client.View.LandlordMenuView;

public class LandlordController implements ActionListener 
{
	private Landlord landlord;
	private LandlordMenuView landlordView;
	private CreatePropertyView newProp;
	private EditPropertyView editProp;
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
		newProp.setFee(propertyFee.getAmount()); //TODO view needs to display the fee paid...
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
		propertyC.displayProperties("landlord", landlordProperties); //TODO:CHECK...
	}

	private void addNewProperty() 
	{
		newProp.setVisible(false);
		Property property = new Property ("address?", newProp.getTypes(), newProp.getBed(), //TODO WHERE is address from
				newProp.getBath(), newProp.getFurnished(),
				newProp.getCity(), landlord.getUserName(), landlord.getEmail());
		
		
		propertyC.addNewProperty(property);
	}

}
