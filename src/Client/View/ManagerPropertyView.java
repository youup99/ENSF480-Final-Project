package Client.View;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import Client.Controller.ManagerController;
import Functionality.Property;

public class ManagerPropertyView extends PropertyView {
	private ManagerController managerc;
	
	public ManagerPropertyView() {
		editView.addSaveListener(this);
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

	@Override
	public void clickedAction(MouseEvent e) {
		JTable target = (JTable) e.getSource();
        int row = target.getSelectedRow();
        Property sendData = propertyList.get(row);
        editView = new EditPropertyView(sendData);
	}




}