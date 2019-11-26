package Client.View;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

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
		int index = table.getSelectedRow();
		Property sendData = propertyList.get(index);
        editView = new EditPropertyView(sendData);
        editView.setVisible(true);
        //propertyInfo.addSendEmailListener(this);
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