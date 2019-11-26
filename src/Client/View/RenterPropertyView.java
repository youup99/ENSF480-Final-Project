package Client.View;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import Functionality.Property;

public class RenterPropertyView extends PropertyView {

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void clickedAction(MouseEvent e) {
		JTable target = (JTable) e.getSource();
        int row = target.getSelectedRow();
        Property sendData = propertyList.get(row);
        propertyInfo = new PropertyInfoView(sendData);
	}
	
}