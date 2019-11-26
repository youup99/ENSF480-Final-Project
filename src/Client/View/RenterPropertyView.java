package Client.View;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import Client.Controller.RenterController;
import Functionality.Property;

public class RenterPropertyView extends PropertyView {
	private RenterController rc;
	
	public RenterPropertyView(String[][] data) {
		super(data);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void setRenterController(RenterController rc) {
		this.rc = rc;
	}

	@Override
	public void clickedAction(MouseEvent e) {
		JTable target = (JTable) e.getSource();
        int row = target.getSelectedRow();
        Property sendData = propertyList.get(row);
        propertyInfo = new PropertyInfoView(sendData);
        propertyInfo.addSendEmailListener(this);
	}

	
}