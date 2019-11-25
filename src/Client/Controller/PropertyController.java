package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import Client.Communication;
import Client.Property;
import Client.View.EditPropertyView;
import Client.View.PropertyView;

public class PropertyController implements ActionListener 
{
    private PropertyView propertyView;
    private EditPropertyView editView;

    public void addListenersToView()
    {
      
    }
    
    public void editProperty (Property p)
    {
    	//functin of editView to display... To be added by Minji
    }
    
    public void displayProperties (String usertype, ArrayList<Property> properties)
    {
    	//function of propertyview with properties passed down to it. Implemented in view; to be added by Minji
    }

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch (e.getActionCommand())
		{
					
		}
		
	}
	
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