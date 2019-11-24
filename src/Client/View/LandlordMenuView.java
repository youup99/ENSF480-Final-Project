package Client.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class LandlordMenuView extends JFrame{
	private JButton editBtn = new JButton("Edit Listing");
	private JButton createBtn = new JButton("Create Listing");
	private JButton exitBtn = new JButton("Exit Program");
	
	public LandlordMenuView() {
		getContentPane().setBackground(new Color(230, 230, 250));
		setTitle("Landlord Menu");
		getContentPane().setLayout(null);
		
		editBtn.setBounds(149, 36, 129, 29);
		getContentPane().add(editBtn);
		
		createBtn.setBounds(149, 112, 129, 29);
		getContentPane().add(createBtn);
		
		exitBtn.setBounds(149, 186, 129, 29);
		getContentPane().add(exitBtn);
		
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