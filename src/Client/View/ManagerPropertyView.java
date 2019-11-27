package Client.View;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Client.Controller.ManagerController;
import Functionality.Property;

public class ManagerPropertyView extends PropertyView {
	private ManagerController managerc;
	
	public ManagerPropertyView(String[][]data, ArrayList<Property> properties) {
		super(data);
		this.setDisplay(properties);
	}
	
	@Override
	public void mouseAction(MouseEvent e) {		
		int index = getTable().getSelectedRow();
		if(propertyList.size() > 0) {
			Property sendData = propertyList.get(index);
			editView = new EditPropertyView(sendData);
			editView.addSaveListener(this);
			editView.setID();
			editView.setStatus();
		}
		else {
			Property sendData = null;
			editView = new EditPropertyView(sendData);
		}
        editView.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Property temp = editView.getSelectedProperty();
		temp.setListingState(editView.getStatus());
		managerc.updateStatus(temp);
	}
	
	public void setManagerController(ManagerController mc) {
		managerc = mc;
	}

}