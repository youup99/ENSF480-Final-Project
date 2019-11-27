package Client.View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import Functionality.Property;


import java.awt.BorderLayout;

public abstract class PropertyView implements ActionListener{
   protected String[] columnNames = {"ID", "Type", "numOfBedroom", "numOfBathroom", "isFurnished", "cityQuadrant"};
   protected String[][] data;
   protected JFrame frame;
//   private String[][] data = {
//         {"12345", "Apartment", "2", "4", "Yes", "NW"},
//         {"67890", "Separate", "1", "3", "No", "SW"},
//   };
   protected ArrayList<Property> propertyList = new ArrayList<Property>();
   
   protected EditPropertyView editView;
   
   protected PropertyInfoView propertyInfo;
   private JTable table;
   
   public PropertyView(String[][] dataa) {
    	Dimension dim = new Dimension(1000,200);
    	frame = new JFrame("Property View");
        frame.setLocation(200,400);
        frame.setSize(dim);
        setTable(new JTable(dataa, columnNames) {
        private static final long serialVersionUID = 1L;
			
		@Override
           public boolean isCellEditable(int row,int column) {
              return false;
           }
        });
        
        JScrollPane scrollpane = new JScrollPane(getTable());
        
        scrollpane.setPreferredSize(dim);
        scrollpane.setVerticalScrollBarPolicy(scrollpane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.getContentPane().add(scrollpane, BorderLayout.CENTER);
        
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel tcm = getTable().getColumnModel();
        
        for(int i = 0; i < tcm.getColumnCount(); i++) {
           tcm.getColumn(i).setCellRenderer(dtcr);
        }
        
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getTable().addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		mouseAction(e);
        	}
        });
    }
   
   public abstract void mouseAction(MouseEvent e);
   
   public abstract void actionPerformed(ActionEvent e);
   
   public void setDisplay(ArrayList<Property> p)  {
	   propertyList = p;
	}

   public void setVisible (boolean b)
   {
	   frame.setVisible(b);
   }

public JTable getTable() {
	return table;
}

public void setTable(JTable table) {
	this.table = table;
}
}

