import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame{
	private JButton landlord = new JButton("Landlord");
	private JButton renter = new JButton("Renter");
	private JButton manager = new JButton("Manager");
	private JButton guest = new JButton("Guest");
	
	public MainView() {
		getContentPane().setBackground(new Color(230, 230, 250));
		setTitle("Main Menu");
		getContentPane().setLayout(null);
		

		landlord.setBounds(66, 57, 115, 56);
		getContentPane().add(landlord);
		
		renter.setBounds(242, 57, 115, 56);
		getContentPane().add(renter);
		
		manager.setBounds(66, 141, 115, 56);
		getContentPane().add(manager);
		
		guest.setBounds(242, 141, 115, 56);
		getContentPane().add(guest);
		
		JLabel options = new JLabel("Please select one of the options");
		options.setBounds(96, 16, 222, 20);
		getContentPane().add(options);
		
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