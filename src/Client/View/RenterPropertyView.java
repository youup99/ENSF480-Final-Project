package Client.View;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import Functionality.Property;

public class RenterPropertyView extends PropertyView {

	public RenterPropertyView(String [][] data) {
		super(data);
	}

	@Override
	public void mouseAction(MouseEvent e) {
		int index = table.getSelectedRow();
		Property sendData = propertyList.get(index);
        editView = new EditPropertyView(sendData);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}