package Client.View;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import Client.Controller.ManagerController;
import Functionality.User;

import java.awt.BorderLayout;

public class UserListView{
   private static final long serialVersionUID = 1L;
   private ManagerController mc;
   private String[] columnNames = {"ID", "UserName", "FirstName", "LastName", "email", "Type"};
   private String[][] data;
   private JFrame frame = new JFrame("User List");
//   private String[][] data = {
//         {"asdf", "Minji", "Kim", "minjikm19@gmail.com", "renter"},
//         {"qfwea", "Youup", "Kim", "youup.kim99@gmail.com", "landlord"},
//   };
   private ArrayList<User> userList = new ArrayList<User>();
   
   public UserListView(String[][] data, ArrayList<User> userList) {
    	Dimension dim = new Dimension(800,200);
        frame.setLocation(200,400);
        frame.setSize(dim);
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
   
   
   public void setManagerController(ManagerController mc) {
	   this.mc = mc;
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

