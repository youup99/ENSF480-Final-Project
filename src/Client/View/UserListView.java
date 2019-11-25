package Client.View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.awt.BorderLayout;

public class UserListView{
   private static final long serialVersionUID = 1L;
   private String[] columnNames = {"UserName", "FirstName", "LastName", "email", "Type"};
   //private String[][] data = setData();
   private String[][] data = {
         {"asdf", "Minji", "Kim", "minjikm19@gmail.com", "renter"},
         {"qfwea", "Youup", "Kim", "youup.kim99@gmail.com", "landlord"},
   };

   public UserListView() {
    	Dimension dim = new Dimension(800,200);
    	JFrame frame = new JFrame("User List");
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

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e) {
              if(e.getClickCount() == 2) {
                 //need to add the way to get data
                 UserInfoView userInfoView = new UserInfoView();
              }
           }
        });
    }
   
   public void setData() {
	   
   }
}

