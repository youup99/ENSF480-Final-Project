package Client.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EmailView extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField subject;
	private JTextField from;
	private JTextArea email = new JTextArea();
	private JButton btnSend = new JButton("send");
	
    public EmailView() {
    	getContentPane().setBackground(new Color(230, 230, 250));
    	setTitle("Send Email");
    	getContentPane().setLayout(null);
    	
    	JLabel fromLbl = new JLabel("From:");
    	fromLbl.setBounds(15, 16, 69, 20);
    	getContentPane().add(fromLbl);
    	
    	JLabel subjectLbl = new JLabel("Subject:");
    	subjectLbl.setBounds(15, 52, 69, 20);
    	getContentPane().add(subjectLbl);
    	
    	email.setLocation(15, 0);
    	email.setLineWrap(true);

    	getContentPane().add(email);
    	JScrollPane scroll = new JScrollPane (email);
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBounds(10, 88, 403, 262); 
        getContentPane().add(scroll);
        
        btnSend.setBounds(150, 358, 115, 29);
        getContentPane().add(btnSend);
        
        subject = new JTextField();
        subject.setBounds(77, 52, 336, 26);
        getContentPane().add(subject);
        subject.setColumns(10);
        
        from = new JTextField();
        from.setBounds(74, 10, 146, 26);
        getContentPane().add(from);
        from.setColumns(10);
        setLocationRelativeTo ( null );
    }
    
    public void addSendListener(ActionListener al)  {
    	btnSend.addActionListener(al);
	}
	
	public String getFrom() {
		return from.getText();
	}
	
	public String getEmail() {
		return email.getText();
	}
}