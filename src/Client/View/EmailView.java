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
	JTextPane to = new JTextPane();
	
    public EmailView() {
    	getContentPane().setBackground(new Color(230, 230, 250));
    	setTitle("Send Email");
    	getContentPane().setLayout(null);
    	
    	JLabel fromLbl = new JLabel("From:");
    	fromLbl.setBounds(15, 43, 69, 20);
    	getContentPane().add(fromLbl);
    	
    	JLabel toLbl = new JLabel("To:");
    	toLbl.setBounds(15, 10, 25, 20);
    	getContentPane().add(toLbl);
    	
    	JLabel subjectLbl = new JLabel("Subject:");
    	subjectLbl.setBounds(15, 69, 69, 20);
    	getContentPane().add(subjectLbl);
    	
    	email.setLocation(23, 0);
    	email.setLineWrap(true);

    	getContentPane().add(email);
    	JScrollPane scroll = new JScrollPane (email);
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBounds(10, 100, 400, 250); 
        getContentPane().add(scroll);
        
        btnSend.setBounds(150, 358, 115, 29);
        getContentPane().add(btnSend);
        
        to.setBounds(43, 10, 177, 26);
        getContentPane().add(to);
        
        subject = new JTextField();
        subject.setBounds(74, 66, 336, 26);
        getContentPane().add(subject);
        subject.setColumns(10);
        
        from = new JTextField();
        from.setBounds(74, 40, 146, 26);
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
	
	public String getSubject() {
		return subject.getText();
	}
	
	public void setTo(String ll) {
		to.setText(ll);
	}
}