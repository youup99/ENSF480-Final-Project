package Client.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollBar;

public class PropertyView extends JFrame {

   private JPanel contentPane;
   private JTable table;
   
   private String[] columnNames = {"ID", "Type", "numOfBedroom", "numOfBathroom", "isFurnished", "cityQuadrant"};
   //private String[][] data = getData();
   private String[][] data = {
            {"12345", "Apartment", "2", "4", "Yes", "NW"},
            {"67890", "Seperate", "1", "3", "No", "SW"},
      };

   /**
    * Create the frame.
    */
   public PropertyView() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 300);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JScrollBar scrollBar = new JScrollBar();
      scrollBar.setBounds(356, 44, 21, 156);
      contentPane.add(scrollBar);
      
      table = new JTable(data,columnNames);
      table.setBounds(56, 44, 321, 156);
      contentPane.add(table);
   }
}