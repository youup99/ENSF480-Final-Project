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
   private String[] columnNames = {"ID", "Type", "numOfBedroom", "numOfBathroom", "isFurnished", "cityQuadrant"};
   private String[][] data;
   private JFrame frame;
//   private String[][] data = {
//         {"12345", "Apartment", "2", "4", "Yes", "NW"},
//         {"67890", "Separate", "1", "3", "No", "SW"},
//   };
   protected ArrayList<Property> propertyList = new ArrayList<Property>();
   
   protected EditPropertyView editView;
   
   protected PropertyInfoView propertyInfo;

   public PropertyView() {
    	Dimension dim = new Dimension(1000,200);
    	frame = new JFrame("Property View");
        frame.setLocation(200,400);
        frame.setSize(dim);
        setData();
        JTable table = new JTable(data, columnNames) {
        private static final long serialVersionUID = 1L;
			
		@Override
           public boolean isCellEditable(int row,int column) {
              return false;
           }
        };
        
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setPreferredSize(dim);
        scrollpane.setVerticalScrollBarPolicy(scrollpane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.getContentPane().add(scrollpane, BorderLayout.CENTER);
        
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel tcm = table.getColumnModel();
        
        for(int i = 0; i < tcm.getColumnCount(); i++) {
           tcm.getColumn(i).setCellRenderer(dtcr);
        }
        
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e) {
              if(e.getClickCount() == 2) {
            	  clickedAction(e);
              }
           }
        });
        
    }
   
   public abstract void clickedAction(MouseEvent e);
   public void setData() {
	   for(int i = 0; i < propertyList.size(); i++) {
		   for(int j = 0; j < 5; j++) {
			    if (j == 0) {
				   data[i][j] = Integer.toString(propertyList.get(i).getID());
       			} else if (j == 1) {
       			   data[i][j] = propertyList.get(i).getType();
       		    } else if (j == 2) {
       			   data[i][j] = Integer.toString(propertyList.get(i).getNumOfBedrooms());
       		    } else if (j == 3) {
       			   data[i][j] = Integer.toString(propertyList.get(i).getNumOfBathrooms());
       		    } else if (j == 4) {
       			   if (propertyList.get(i).isFurnished() == true) {
       				   data[i][j] = "Yes";
       			   } else if (propertyList.get(i).isFurnished() == false) {
       				   data[i][j] = "No";
       			   }
       		    } else if (j == 5) {
       			   data[i][j] = propertyList.get(i).getCityQuadrant();
       		    }
       	   }
       }
   }
   
   public void setDisplay(ArrayList<Property> p)  {
	   propertyList = p;
	}

   @Override
   abstract public void actionPerformed(ActionEvent e);
   
   public void setVisible (boolean b)
   {
	   frame.setVisible(b);
   }
}

