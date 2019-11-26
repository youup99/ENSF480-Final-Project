package Client.View;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import Client.Controller.LandlordController;
import Functionality.Property;

public class LandlordPropertyView extends PropertyView {
	private LandlordController landc;
	
	public LandlordPropertyView(String[][] data) {
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
		landc.updateStatus(temp);
	}
	
	public void setLandlordController(LandlordController llc) {
		landc = llc;
	}
}