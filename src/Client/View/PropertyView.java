package Client.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PropertyView extends JFrame{
	private static final long serialVersionUID = 1L;
	private String[] columnNames = {"ID", "Type", "numOfBedroom", "numOfBathroom", "isFurnished", "cityQuadrant"};
	//private String[][] data = getData();
	private String[][] data = {
			{"12345", "Apartment", "2", "4", "Yes", "NW"},
			{"67890", "Seperate", "1", "3", "No", "SW"},
	};
	private JTable table = new JTable(data, columnNames);
	
    public PropertyView() {
    	JTable table = new JTable(data, columnNames);
    	table.setFillsViewportHeight(true);
    	table.setEnabled(false);
    	table.setCellSelectionEnabled(true);
    	table.setColumnSelectionAllowed(true);

    	JScrollPane scrollPane = new JScrollPane(table);
    	scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    	getContentPane().add(scrollPane, BorderLayout.WEST);
        
        setTitle("Property View");    
        pack();
        setVisible(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new MouseAdapter() {
        	public void mouseCliced(MouseEvent e) {
        		if(e.getClickCount() == 2) {
        			//need to add the way to get data
        			PropertyInfoView propertyInfoView = new PropertyInfoView();
        		}
        	}
        });

    }
}