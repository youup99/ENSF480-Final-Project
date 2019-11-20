package Client.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PropertyView extends JFrame{
	private String[] columnNames = {"ID", "Type", "numOfBedroom", "numOfBathroom", "isFurnished", "cityQuadrant"};
	//private String[][] data = getData();
	private String[][] data = {
			{"12345", "Apartment", "2", "4", "Yes", "NW"},
			{"67890", "Seperate", "1", "3", "No", "SW"},
	};
	private JTable table = new JTable(data, columnNames);
	
    public PropertyView() {
    	table.setColumnSelectionAllowed(true);
    	table.setEnabled(false);

    	JScrollPane scrollPane = new JScrollPane(table);
    	scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    	getContentPane().add(scrollPane, BorderLayout.SOUTH);
        
        setTitle("Property View");    
        pack();
        setVisible(true);
    }
}