package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Client.Communication;
import Client.Property;
import Client.View.RenterMenuView;;

public class RenterController implements ActionListener, GeneralRenterController 
{
	private RenterMenuView renterView;
	private SearchController search;
	
	public RenterController ()
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
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand().equals("exit"))
		{
			renterView.setVisible(false);
			return;
		}
		
		search =  new SearchController (this);
	}
	
	public void getSearchData (Property data)
	{
		Communication cToS = Communication.getInstance();
		
	}

}
