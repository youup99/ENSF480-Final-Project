package Client.View;

import java.util.Enumeration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChangeFeeView extends JFrame{
	private JTextField changeFee;
	private JTextField changePeriod;
	private JButton submit = new JButton("submit");
	
	public ChangeFeeView() {
		getContentPane().setBackground(new Color(230, 230, 250));
		setTitle("Change Fee");
		getContentPane().setLayout(null);
		
		JLabel currentFeeLbl = new JLabel("Current Fee: $");
		currentFeeLbl.setBounds(15, 16, 115, 20);
		getContentPane().add(currentFeeLbl);
		
		JTextArea currentFee = new JTextArea();
		currentFee.setEditable(false);
		currentFee.setBounds(123, 16, 93, 24);
		getContentPane().add(currentFee);
		
		JLabel currentPeriodLbl = new JLabel("Current Period:");
		currentPeriodLbl.setBounds(15, 49, 115, 20);
		getContentPane().add(currentPeriodLbl);
		
		JTextArea currentPeriod = new JTextArea();
		currentPeriod.setEditable(false);
		currentPeriod.setBounds(123, 49, 93, 24);
		getContentPane().add(currentPeriod);
		
		JLabel changeFeeLbl = new JLabel("Change Fee to: $ ");
		changeFeeLbl.setBounds(15, 85, 134, 20);
		getContentPane().add(changeFeeLbl);
		
		JLabel changePeriodLbl = new JLabel("Change Period to:");
		changePeriodLbl.setBounds(15, 121, 134, 20);
		getContentPane().add(changePeriodLbl);
		
		changeFee = new JTextField();
		changeFee.setBounds(144, 82, 72, 26);
		getContentPane().add(changeFee);
		changeFee.setColumns(10);
		
		changePeriod = new JTextField();
		changePeriod.setBounds(144, 118, 76, 26);
		getContentPane().add(changePeriod);
		changePeriod.setColumns(10);
		
		JLabel lblDays = new JLabel("days");
		lblDays.setBounds(222, 121, 38, 20);
		getContentPane().add(lblDays);
		
		JLabel label = new JLabel("days");
		label.setBounds(222, 49, 38, 20);
		getContentPane().add(label);
		
		submit.setBounds(71, 157, 115, 29);
		getContentPane().add(submit);
	}
	
	public void addSubmitListener(ActionListener al)  {
    	submit.addActionListener(al);
	}
	
	public String getChangeFee() {
		return changeFee.getText();
	}
	
	public String getChangePeriod() {
		return changePeriod.getText();
	}
}