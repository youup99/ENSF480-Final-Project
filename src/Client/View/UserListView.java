package Client.View;

import java.awt.Dimension;
import java.awt.Toolkit;
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

import Functionality.User;

import java.awt.BorderLayout;

public class UserListView{
   private static final long serialVersionUID = 1L;
   private String[] columnNames = {"ID", "UserName", "FirstName", "LastName", "email", "Type"};
   private String[][] data;
//   private String[][] data = {
//         {"asdf", "Minji", "Kim", "minjikm19@gmail.com", "renter"},
//         {"qfwea", "Youup", "Kim", "youup.kim99@gmail.com", "landlord"},
//   };
   private ArrayList<User> userList = new ArrayList<User>();
   
   public UserListView() {
    	Dimension dim = new Dimension(800,200);
    	JFrame frame = new JFrame("User List");
        frame.setLocation(200,400);
        frame.setSize(dim);
        setData();
        JTable table = new JTable(data, columnNames) {
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
    }
   
   public void setData() {
	   for(int i = 0; i < userList.size(); i++) {
		   for(int j = 0; j < 5; j++) {
			    if (j == 0) {
			       data[i][j] = Integer.toString(userList.get(i).getID());
			    } else if (j == 1) {
				   data[i][j] = userList.get(i).getUserName();
       			} else if (j == 2) {
       			   data[i][j] = userList.get(i).getFirstName();
       		    } else if (j == 3) {
       			   data[i][j] = userList.get(i).getLastName();
       		    } else if (j == 4) {
       			   data[i][j] = userList.get(i).getEmail();
       		    } else if (j == 5) {
       			   data[i][j] = userList.get(i).getType();
       		    }
       	   }
       }
   }
  public void setVisible (boolean b)
   {
	frame.setVisible(b); 
   }
	
  public void setDisplay (ArrayList<User> users)
   {
	   userList = users;
   }
}

