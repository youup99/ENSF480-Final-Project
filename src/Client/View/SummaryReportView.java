package Client.View;

import java.util.Enumeration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SummaryReportView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea houseList = new JTextArea();
	private JTextArea houseRent = new JTextArea();
	private JTextArea activeListing = new JTextArea();
	private JButton btnClose = new JButton("Close");
	
	public SummaryReportView() {
		setTitle("Summary Report");
		getContentPane().setBackground(new Color(230, 230, 250));
		getContentPane().setLayout(null);
		
		JLabel listedLbl = new JLabel("Number of Houses Listed: ");
		listedLbl.setBounds(15, 16, 189, 20);
		getContentPane().add(listedLbl);
		
		JLabel rentedLbl = new JLabel("Number of Houses Rented:");
		rentedLbl.setBounds(15, 51, 197, 20);
		getContentPane().add(rentedLbl);
		
		JLabel activeLbl = new JLabel("Number of Active Listings:");
		activeLbl.setBounds(15, 87, 189, 20);
		getContentPane().add(activeLbl);
		
		houseList.setEditable(false);
		houseList.setEnabled(false);
		houseList.setForeground(new Color(0, 0, 0));
		houseList.setBounds(208, 16, 66, 24);
		getContentPane().add(houseList);
		
		houseRent.setForeground(Color.BLACK);
		houseRent.setEnabled(false);
		houseRent.setEditable(false);
		houseRent.setBounds(208, 52, 66, 24);
		getContentPane().add(houseRent);
		
		activeListing.setForeground(Color.BLACK);
		activeListing.setEnabled(false);
		activeListing.setEditable(false);
		activeListing.setBounds(208, 87, 66, 24);
		getContentPane().add(activeListing);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 123, 497, 2);
		getContentPane().add(separator);
		
		JLabel listLbl = new JLabel("List of Houses Rented");
		listLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		listLbl.setBounds(10, 132, 194, 20);
		getContentPane().add(listLbl);
		
		btnClose.setBounds(191, 382, 115, 29);
		getContentPane().add(btnClose);
		//Add List
	}
	
	public void addCloseListener(ActionListener al)  {
    	btnClose.addActionListener(al);
	}
	
	public void setNumHouseList(int n) {
		houseList.setText(Integer.toString(n));
	}
	
	public void setNumHouseRent(int n) {
		houseRent.setText(Integer.toString(n));
	}
	
	public void setNumActiveList(int n) {
		activeListing.setText(Integer.toString(n));
	}
}