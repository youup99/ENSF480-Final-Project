package Client.View;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import Client.Controller.ManagerController;
import Functionality.Property;

public class ManagerPropertyView extends PropertyView {
	private ManagerController managerc;
	
	public ManagerPropertyView(String[][]data) {
		super(data);
		editView.addSaveListener(this);
	}
	
	@Override
	public void mouseAction(MouseEvent e) {
		int index = table.getSelectedRow();
		Property sendData = propertyList.get(index);
        editView = new EditPropertyView(sendData);
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