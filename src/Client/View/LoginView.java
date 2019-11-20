import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
	private JTextField nameInput;
	private JTextField pwInput;
	private JButton login = new JButton("login");
	private JButton signUp = new JButton("Sign Up");
	
    public LoginView() {
    	getContentPane().setBackground(new Color(230, 230, 250));
    	setTitle("Login");
    	getContentPane().setLayout(null);
    	
    	nameInput = new JTextField();
    	nameInput.setBounds(168, 64, 146, 26);
    	getContentPane().add(nameInput);
    	nameInput.setColumns(10);
    	
    	pwInput = new JTextField();
    	pwInput.setBounds(168, 98, 146, 26);
    	getContentPane().add(pwInput);
    	pwInput.setColumns(10);
    	

    	login.setBounds(329, 98, 96, 27);
    	getContentPane().add(login);
    	
    	JLabel nameLbl = new JLabel("Username");
    	nameLbl.setBounds(69, 67, 84, 20);
    	getContentPane().add(nameLbl);
    	
    	JLabel pwLbl = new JLabel("Password");
    	pwLbl.setBounds(69, 102, 69, 20);
    	getContentPane().add(pwLbl);
    	
    	JLabel insturction = new JLabel("Please enter your username and password");
    	insturction.setBounds(96, 31, 305, 20);
    	getContentPane().add(insturction);
    	
    	signUp.setBounds(329, 64, 96, 27);
    	getContentPane().add(signUp);
    	
    }
    
    public void addLoginListener(ActionListener al)  {
    	login.addActionListener(al);
	}
    
    public void addNewListener(ActionListener al)  {
    	signUp.addActionListener(al);
	}
    
    public String getUsername()  {
		return nameInput.getText();
	}
	
	public String getPassword()  {
		return pwInput.getText();
	}
}