package Client.View;

import java.util.Enumeration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PropertyInfoView extends JFrame{
	private JButton emailBtn = new JButton("Click to send email to landlord");
	private JTextArea ID = new JTextArea();
	private JTextArea address = new JTextArea();
	private JTextArea numOfBeds = new JTextArea();
	private JTextArea numOfBaths = new JTextArea();
	private JTextArea furnished = new JTextArea();
	private JTextArea cityQuadrant = new JTextArea();
	
	public PropertyInfoView() {
		getContentPane().setBackground(new Color(230, 230, 250));
		setTitle("Property View");
		getContentPane().setLayout(null);
		
		JLabel addressLbl = new JLabel("Address");
		addressLbl.setBounds(15, 50, 69, 20);
		getContentPane().add(addressLbl);
		
		JLabel idLbl = new JLabel("ID");
		idLbl.setBounds(15, 16, 69, 20);
		getContentPane().add(idLbl);
		
		JLabel bedLbl = new JLabel("Number of bedrooms");
		bedLbl.setBounds(15, 86, 152, 20);
		getContentPane().add(bedLbl);
		
		JLabel bathLbl = new JLabel("Number of bathrooms");
		bathLbl.setBounds(15, 122, 162, 20);
		getContentPane().add(bathLbl);
		
		JLabel furnishedLbl = new JLabel("Furnished");
		furnishedLbl.setBounds(15, 158, 69, 20);
		getContentPane().add(furnishedLbl);
		
		JLabel quadLbl = new JLabel("City Quadrant");
		quadLbl.setBounds(15, 191, 98, 20);
		getContentPane().add(quadLbl);
		
		emailBtn.setBounds(81, 239, 247, 29);
		getContentPane().add(emailBtn);
		
		ID.setEditable(false);
		ID.setBounds(99, 16, 68, 24);
		getContentPane().add(ID);
		
		address.setEditable(false);
		address.setBounds(99, 50, 314, 24);
		getContentPane().add(address);
		
		numOfBeds.setEditable(false);
		numOfBeds.setBounds(182, 86, 35, 24);
		getContentPane().add(numOfBeds);
		
		numOfBaths.setEditable(false);
		numOfBaths.setBounds(182, 122, 35, 24);
		getContentPane().add(numOfBaths);
		
		furnished.setEditable(false);
		furnished.setBounds(115, 158, 52, 24);
		getContentPane().add(furnished);
		
		cityQuadrant.setEditable(false);
		cityQuadrant.setBounds(125, 191, 52, 24);
		getContentPane().add(cityQuadrant);
	}
	
	public void addSendEmailListener(ActionListener al)  {
    	emailBtn.addActionListener(al);
	}
	
	public void setIDField(int id) {
		String data = Integer.toString(id);
		ID.setText(data);
	}
	
	public void setAddressField(String ad) {
		address.setText(ad);
	}
	
	public void setNumOfBedField(int n) {
		String data = Integer.toString(n);
		numOfBeds.setText(data);
	}
	
	public void setNumOfBathField(int n) {
		String data = Integer.toString(n);
		numOfBaths.setText(data);
	}
	
	public void setFurnished(boolean b) {
		String data;
		if (b == true) {
			data = "yes";
		} else {
			data = "no";
		}
		furnished.setText(data);
	}
	
	public void setCityQuadrant(String cq) {
		cityQuadrant.setText(cq);
	}
}