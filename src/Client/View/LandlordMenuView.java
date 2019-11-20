package Client.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class LandlordMenuView extends JFrame{
	private JButton feeBtn = new JButton("Pay Fees");
	private JButton editBtn = new JButton("Edit Listing");
	private JButton createBtn = new JButton("Create Listing");
	private JButton exitBtn = new JButton("Exit Program");
	
	public LandlordMenuView() {
		getContentPane().setBackground(new Color(230, 230, 250));
		setTitle("Landlord Menu");
		getContentPane().setLayout(null);
		
		feeBtn.setBounds(149, 16, 129, 29);
		getContentPane().add(feeBtn);
		
		editBtn.setBounds(149, 72, 129, 29);
		getContentPane().add(editBtn);
		
		createBtn.setBounds(149, 130, 129, 29);
		getContentPane().add(createBtn);
		
		exitBtn.setBounds(149, 186, 129, 29);
		getContentPane().add(exitBtn);
		
	}
	
	public void addFeeListener(ActionListener al)  {
    	feeBtn.addActionListener(al);
	}
    
    public void addEditListener(ActionListener al)  {
    	editBtn.addActionListener(al);
	}
    
    public void addCreateListener(ActionListener al)  {
    	createBtn.addActionListener(al);
	}
    
    public void addExitListener(ActionListener al)  {
    	exitBtn.addActionListener(al);
	}
}