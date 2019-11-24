package Client.View;

import java.util.Enumeration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ManagerMenuView extends JFrame{
	private JButton changeStatus = new JButton("Change Property Status");
	private JButton changeFee = new JButton("Change Fee");
	private JButton getUserInfo = new JButton("Get Information of Users");
	private JButton exit = new JButton("Exit");
	
	public ManagerMenuView() {
		getContentPane().setBackground(new Color(230, 230, 250));
		setTitle("Manager Menu");
		getContentPane().setLayout(null);
		
		changeStatus.setBounds(106, 34, 199, 29);
		getContentPane().add(changeStatus);
		
		changeFee.setBounds(149, 89, 115, 29);
		getContentPane().add(changeFee);
		
		getUserInfo.setBounds(106, 144, 209, 29);
		getContentPane().add(getUserInfo);
		
		exit.setBounds(149, 199, 115, 29);
		getContentPane().add(exit);
	}
	
	public void addChangeStatusListener(ActionListener al)  {
    	changeStatus.addActionListener(al);
	}
    
    public void addChangeFeeListener(ActionListener al)  {
    	changeFee.addActionListener(al);
	}
    
    public void addGetUserInfoListener(ActionListener al)  {
    	getUserInfo.addActionListener(al);
	}
    
    public void addExitListener(ActionListener al)  {
    	exit.addActionListener(al);
	}
}