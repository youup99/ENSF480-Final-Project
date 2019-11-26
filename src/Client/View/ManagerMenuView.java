package Client.View;

import java.util.Enumeration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerMenuView extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton changeStatus = new JButton("Change Property Status");
	private JButton changeFee = new JButton("Change Fee");
	private JButton getUserInfo = new JButton("Get Information of Users");
	private JButton exit = new JButton("Exit");
	private JButton createNewReport = new JButton("Create New Summary Report");
	
	public ManagerMenuView() {
		setSize(431, 310);
		getContentPane().setBackground(new Color(230, 230, 250));
		setTitle("Manager Menu");
		getContentPane().setLayout(null);
		
		changeStatus.setBounds(106, 16, 199, 29);
		getContentPane().add(changeStatus);
		
		changeFee.setBounds(149, 61, 115, 29);
		getContentPane().add(changeFee);
		getUserInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		getUserInfo.setBounds(106, 106, 209, 29);
		getContentPane().add(getUserInfo);
		
		exit.setBounds(149, 199, 115, 29);
		getContentPane().add(exit);
		
		createNewReport.setBounds(91, 151, 239, 29);
		getContentPane().add(createNewReport);
	}
	
	public void addChangeStatusListener(ActionListener al)  {
    	changeStatus.addActionListener(al);
    	changeStatus.setActionCommand("change status");
	}
    
    public void addChangeFeeListener(ActionListener al)  {
    	changeFee.addActionListener(al);
    	changeFee.setActionCommand("change fee");
	}
    
    public void addGetUserInfoListener(ActionListener al)  {
    	getUserInfo.addActionListener(al);
    	getUserInfo.setActionCommand("getInfo");
	}
    
    public void addExitListener(ActionListener al)  {
    	exit.addActionListener(al);
	}
    
    public void addCreateListener(ActionListener al) {
    	createNewReport.addActionListener(al);
    }
}