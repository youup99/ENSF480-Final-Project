package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Client.Communication;
import Client.Property;
import Client.View.PropertyView;

public class PropertyController implements ActionListener 
{
    private PropertyView propertyView;

    public void addListenersToView()
    {
        
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
		} catch (IOException e) {
			e.printStackTrace();
		}		
		//Is server gonna give confirmation? If yes, write code to read that object from socket.
	}
}