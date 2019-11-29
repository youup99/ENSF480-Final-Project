package Client.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RenterMenuView extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton searchBtn = new JButton("Search");
	private JButton exitBtn = new JButton("Exit Program");
	
	public RenterMenuView() {
		setSize(418, 281);
		getContentPane().setBackground(new Color(230, 230, 250));
		setTitle("Renter Menu");
		getContentPane().setLayout(null);
		
		searchBtn.setBounds(124, 46, 129, 29);
		getContentPane().add(searchBtn);
		
		exitBtn.setBounds(124, 160, 132, 29);
		getContentPane().add(exitBtn);
	}
	
	public void addSearchListener(ActionListener al)  {
    	searchBtn.addActionListener(al);
    	searchBtn.setActionCommand("search");
	}
    
    public void addExitListener(ActionListener al)  {
    	exitBtn.addActionListener(al);
    	exitBtn.setActionCommand("exit");
	}
}