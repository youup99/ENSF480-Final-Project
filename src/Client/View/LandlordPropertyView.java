package Client.View;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import Client.Controller.LandlordController;
import Functionality.Property;

public class LandlordPropertyView extends PropertyView {
	private LandlordController landc;
	
	public LandlordPropertyView(String[][] data) {
		super(data);
		editView.addSaveListener(this);
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

	@Override
	public void clickedAction(MouseEvent e) {
		JTable target = (JTable) e.getSource();
        int row = target.getSelectedRow();
        Property sendData = propertyList.get(row);
        editView = new EditPropertyView(sendData);
	}
	
}