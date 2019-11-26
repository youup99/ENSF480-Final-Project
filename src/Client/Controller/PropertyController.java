package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import Client.Communication;
import Client.View.EditPropertyView;
import Client.View.PropertyView;
import Functionality.Property;

public class PropertyController
{
    private PropertyView propertyView;
    private EditPropertyView editView;
	
	public void addNewProperty (Property property) 
	{
		Communication ctos = Communication.getInstance();
		try {
			ctos.sendString("add property");
			ctos.sendProperty(property);
			ctos.getString(); //to read the found. 
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}				
		
		try {
			if(ctos.getString().contentEquals("added")) {
				System.out.println("Error adding property");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}