package Client.View;

import java.util.Enumeration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserInfoView extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton deleteUser = new JButton("Delete User");
	private JButton close = new JButton("Close");
	private JTextArea userName = new JTextArea();
	private JTextArea firstName = new JTextArea();
	private JTextArea lastName = new JTextArea();
	private JTextArea email = new JTextArea();
	private JTextArea type = new JTextArea();
	
	public UserInfoView() {
		getContentPane().setBackground(new Color(230, 230, 250));
		setTitle("User Informaiton");
		getContentPane().setLayout(null);
		
		JLabel usernameLbl = new JLabel("Username");
		usernameLbl.setBounds(15, 16, 79, 20);
		getContentPane().add(usernameLbl);
		
		JLabel fnameLbl = new JLabel("First Name");
		fnameLbl.setBounds(15, 52, 79, 20);
		getContentPane().add(fnameLbl);
		
		JLabel lnameLbl = new JLabel("Last Name");
		lnameLbl.setBounds(15, 88, 79, 20);
		getContentPane().add(lnameLbl);
		
		JLabel emailLbl = new JLabel("Email");
		emailLbl.setBounds(15, 126, 69, 20);
		getContentPane().add(emailLbl);
		
		JLabel typeLbl = new JLabel("Type");
		typeLbl.setBounds(15, 162, 69, 20);
		getContentPane().add(typeLbl);
		
		deleteUser.setBounds(25, 198, 115, 29);
		getContentPane().add(deleteUser);
		
		close.setBounds(174, 198, 115, 29);
		getContentPane().add(close);
		userName.setEditable(false);
		
		userName.setBounds(109, 16, 180, 24);
		getContentPane().add(userName);
		firstName.setEditable(false);
		
		firstName.setBounds(109, 52, 180, 24);
		getContentPane().add(firstName);
		lastName.setEditable(false);
		
		lastName.setBounds(109, 88, 180, 24);
		getContentPane().add(lastName);
		email.setEditable(false);
		
		email.setBounds(109, 126, 180, 24);
		getContentPane().add(email);
		type.setEditable(false);
		
		type.setBounds(109, 162, 180, 24);
		getContentPane().add(type);
	}
	
	public void addDeleteUserListener(ActionListener al)  {
    	deleteUser.addActionListener(al);
	}
	
	public void addCloserListener(ActionListener al) {
		close.addActionListener(al);
	}
	
	public void setUserName(String uName) {
		userName.setText(uName);
	}
	
	public void setFirstName(String fName) {
		firstName.setText(fName);
	}
	
	public void setLastName(String lName) {
		lastName.setText(lName);
	}
	
	public void setEmail(String e) {
		email.setText(e);
	}
	
	public void setType(String t) {
		type.setText(t);
	}
}