package Client.View;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import Client.Controller.GuestController;
import Client.Controller.RenterController;
import Functionality.Property;

public class RenterPropertyView extends PropertyView {
	private RenterController rc;
	private GuestController gc;
	
	public RenterPropertyView(String[][] data) {
		super(data);
	}

	@Override
	public void mouseAction(MouseEvent e) {
		int index = getTable().getSelectedRow();
		if (propertyList.size() > 0) {
			Property sendData = propertyList.get(index);
			propertyInfo = new PropertyInfoView(sendData);
		} else {
			Property sendData = null;
			propertyInfo = new PropertyInfoView(sendData);
		}
		propertyInfo.setVisible(true);
		propertyInfo.addSendEmailListener(this);
	}
	
	public void setRenterController(RenterController rc) {
		this.rc = rc;
	}
	
	public void setGuestController(GuestController gc) {
		this.gc = gc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}