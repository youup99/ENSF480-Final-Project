package Client.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton landlord = new JButton("Landlord");
	private JButton renter = new JButton("Renter");
	private JButton manager = new JButton("Manager");
	private JButton guest = new JButton("Guest");
	
	public MainView() {
		getContentPane().setBackground(new Color(230, 230, 250));
		setTitle("Main Menu");
		getContentPane().setLayout(null);
		setSize(450, 300);
		

		landlord.setBounds(66, 57, 115, 56);
		getContentPane().add(landlord);
		landlord.setActionCommand("Landlord");
		renter.setBounds(242, 57, 115, 56);
		getContentPane().add(renter);
		renter.setActionCommand("Registered");
		manager.setBounds(66, 141, 115, 56);
		getContentPane().add(manager);
		manager.setActionCommand("Manager");
		guest.setBounds(242, 141, 115, 56);
		getContentPane().add(guest);
		guest.setActionCommand("guest");
		JLabel optionsLbl = new JLabel("Please select one of the options");
		optionsLbl.setBounds(96, 16, 222, 20);
		getContentPane().add(optionsLbl);
		
		JLabel exitLbl = new JLabel("Or click X to exit");
		exitLbl.setBounds(154, 213, 126, 20);
		getContentPane().add(exitLbl);
		
	}
	
	public void addLandlordListener(ActionListener al)  {
    	landlord.addActionListener(al);
	}
    
    public void addRenterListener(ActionListener al)  {
    	renter.addActionListener(al);
	}
    
    public void addManagerListener(ActionListener al)  {
    	manager.addActionListener(al);
	}
    
    public void addGuestListener(ActionListener al)  {
    	guest.addActionListener(al);
	}
}