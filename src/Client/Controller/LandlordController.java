package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Client.Communication;
import Client.Landlord;
import Client.Property;
import Client.View.CreatePropertyView;
import Client.View.LandlordMenuView;

public class LandlordController implements ActionListener 
{
	private Landlord landlord;
	private LandlordMenuView landlordView;
	private CreatePropertyView newProp;
	private PropertyController propertyC;
	
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
		newProp = new CreatePropertyView ();
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
		case "add property":
			this.addProperty();
			break;
		case "edit property":
			this.getLandlordProperties();
			break;
		case "addSubmit":
			addNewProperty();
		}
	}
	
	private void getLandlordProperties ()
	{
		//Communicate to server to get data. Assign properties to arraylist in landlord object.
	}

	private void addNewProperty() 
	{
		newProp.setVisible(false);
		Property property = new Property ("", newProp.getTypes(), newProp.getBed(),
				newProp.getBath(), newProp.getFurnished(),
				newProp.getCity(), landlord.getUserName(), landlord.getEmail());
		
		propertyC.addNewProperty(property);		
		//Is server gonna give confirmation? If yes, write code to read that object from socket.
	}

}
