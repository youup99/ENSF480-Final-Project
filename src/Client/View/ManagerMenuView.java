package Client.View;

import java.util.Enumeration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ManagerMenuView extends JFrame{
	private JButton btnNewButton = new JButton("Change Property Status");
	private JButton btnNewButton_1 = new JButton("Change Fee");
	private JButton btnNewButton_2 = new JButton("Get Information of Users");
	private JButton btnExit = new JButton("Exit");
	
	public ManagerMenuView() {
		getContentPane().setBackground(new Color(230, 230, 250));
		setTitle("Manager Menu");
		getContentPane().setLayout(null);
		
		btnNewButton.setBounds(106, 34, 199, 29);
		getContentPane().add(btnNewButton);
		
		btnNewButton_1.setBounds(149, 89, 115, 29);
		getContentPane().add(btnNewButton_1);
		
		btnNewButton_2.setBounds(106, 144, 209, 29);
		getContentPane().add(btnNewButton_2);
		
		btnExit.setBounds(149, 199, 115, 29);
		getContentPane().add(btnExit);
	}
}