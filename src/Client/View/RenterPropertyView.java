package Client.View;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import Client.Controller.EmailController;
import Client.Controller.GuestController;
import Client.Controller.RenterController;
import Functionality.Property;

public class RenterPropertyView extends PropertyView {
	private RenterController rc;
	private GuestController gc;
	private Property selectedProperty;
	private EmailView ev;
	
	public RenterPropertyView(String[][] data) {
		super(data);
	}

	@Override
	public void mouseAction(MouseEvent e) {
		int index = getTable().getSelectedRow();
		if (propertyList.size() > 0) {
			selectedProperty = propertyList.get(index);
			propertyInfo = new PropertyInfoView(selectedProperty);
		} else {
			selectedProperty = null;
			propertyInfo = new PropertyInfoView(selectedProperty);
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
	
	public EmailView getEmailView() {
		return ev;
	}
	
	public Property getSelectedProperty() {
		return selectedProperty;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// sending email
		ev = new EmailView(selectedProperty.getLandlordEmail());
		ev.setRenterController(rc);
		ev.setGuestController(gc);
		ev.addSendListener(rc);
		ev.addSendListener(gc);
		ev.setVisible(true);
	}
}