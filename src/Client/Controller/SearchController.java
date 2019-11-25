package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Client.Property;
import Client.View.SearchView;

public class SearchController implements ActionListener
{
    private SearchView searchView;
    private GeneralRenterController renter; //Both guest and registered
    
    public SearchController (GeneralRenterController control)
    {
    	searchView = new SearchView ();
    	searchView.setVisible(true);
    	addListenersToView();
    	renter = control;
    }

    public void addListenersToView()
    {
        searchView.addSubmitListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Property criteria = new Property ("", searchView.getTypes(), Integer.parseInt(searchView.getBed()),
				Integer.parseInt(searchView.getBath()), searchView.getFurnished(), searchView.getCity(), null, null );
		searchView.setVisible(false);
		renter.getSearchData(criteria);		
	}
}