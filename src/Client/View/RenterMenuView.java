package Client.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class RenterMenuView extends JFrame{
	private JButton searchBtn = new JButton("Search");
	private JButton exitBtn = new JButton("Exit Program");
	
	public RenterMenuView() {
		getContentPane().setBackground(new Color(230, 230, 250));
		setTitle("Renter Menu");
		getContentPane().setLayout(null);
		
		searchBtn.setBounds(140, 58, 129, 29);
		getContentPane().add(searchBtn);
		
		exitBtn.setBounds(140, 160, 132, 29);
		getContentPane().add(exitBtn);
	}
	
	public void addSearchListener(ActionListener al)  {
    	searchBtn.addActionListener(al);
	}
    
    public void addExitListener(ActionListener al)  {
    	exitBtn.addActionListener(al);
	}
}