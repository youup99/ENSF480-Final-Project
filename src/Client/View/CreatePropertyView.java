package Client.View;

import java.util.Date;
import java.util.Enumeration;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CreatePropertyView extends JFrame{
	private static final long serialVersionUID = 1L;
	private String[] types = {"Apartment", "Attached House", "Detached House", "Townhouse"};
	private String[] nums = {"1", "2", "3", "4", "5"};
	private String[] quadrant = {"SW", "NW", "SE", "NE"};
	private JComboBox typeBox = new JComboBox(types);
	private JButton submit = new JButton("Submit");
	private JComboBox bedBox = new JComboBox(nums);
	private JComboBox bathBox = new JComboBox(nums);
	private JComboBox cityBox = new JComboBox(quadrant);
	private JRadioButton yesBtn = new JRadioButton("yes");
	private JRadioButton noBtn = new JRadioButton("no");
	private ButtonGroup group = new ButtonGroup();
	private final JLabel cardNumLbl = new JLabel("Card Number");
	private final JLabel expiryDateLbl = new JLabel("Expiry Date");
	private final JLabel cvvLbl = new JLabel("CVV");
	private final JLabel addressLbl = new JLabel("Address");
	private JTextField holderName = new JTextField();
	private JTextField cardNum = new JTextField();
	private JTextField cvv = new JTextField();
	private JTextArea currentFee = new JTextArea();
	private JFormattedTextField expiryDate = new JFormattedTextField(new SimpleDateFormat("yyyy/MM"));
	private JTextField address;
	
	public CreatePropertyView() {
		expiryDate.setValue(new Date());
        setSize(450, 543);
		cvv.setBounds(176, 404, 61, 26);
		cvv.setColumns(10);
		cardNum.setBounds(176, 331, 177, 26);
		cardNum.setColumns(10);
		holderName.setBounds(176, 295, 177, 26);
		holderName.setColumns(10);
		getContentPane().setBackground(new Color(230, 230, 250));
		setTitle("Create New Property");
		getContentPane().setLayout(null);
		
		JLabel typeLbl = new JLabel("Type");
		typeLbl.setBounds(41, 19, 69, 20);
		getContentPane().add(typeLbl);
		
		JLabel bedLbl = new JLabel("# of Bedrooms");
		bedLbl.setBounds(41, 55, 107, 20);
		getContentPane().add(bedLbl);
		
		JLabel bathLbl = new JLabel("# of bathrooms");
		bathLbl.setBounds(41, 91, 123, 20);
		getContentPane().add(bathLbl);
		
		JLabel FurLbl = new JLabel("Furnished");
		FurLbl.setBounds(41, 127, 69, 20);
		getContentPane().add(FurLbl);
		
		JLabel cityLbl = new JLabel("City quadrant");
		cityLbl.setBounds(41, 163, 107, 20);
		getContentPane().add(cityLbl);
		
		typeBox.setBounds(157, 16, 196, 26);
		getContentPane().add(typeBox);
		
		bedBox.setBounds(157, 52, 36, 26);
		getContentPane().add(bedBox);
		
		bathBox.setBounds(157, 88, 36, 26);
		getContentPane().add(bathBox);
		
		cityBox.setBounds(157, 160, 56, 26);
		getContentPane().add(cityBox);
		
		yesBtn.setBounds(152, 123, 61, 29);
		getContentPane().add(yesBtn);
		
		noBtn.setBounds(217, 123, 61, 29);
		getContentPane().add(noBtn);
		
		group.add(yesBtn);
		group.add(noBtn);
		
		submit.setBounds(144, 441, 115, 29);
		getContentPane().add(submit);
		
		JLabel payInfoLbl = new JLabel("Payment Information");
		payInfoLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		payInfoLbl.setBounds(41, 270, 182, 20);
		getContentPane().add(payInfoLbl);
		
		JLabel nameLbl = new JLabel("Card Holder Name");
		nameLbl.setBounds(41, 298, 131, 20);
		getContentPane().add(nameLbl);
		cardNumLbl.setBounds(41, 334, 107, 20);
		
		getContentPane().add(cardNumLbl);
		expiryDateLbl.setBounds(41, 370, 96, 20);
		
		getContentPane().add(expiryDateLbl);
		cvvLbl.setBounds(41, 407, 42, 20);
		
		getContentPane().add(cvvLbl);
		
		address = new JTextField();
		address.setBounds(157, 196, 256, 26);
		getContentPane().add(address);
		address.setColumns(10);
		
		getContentPane().add(holderName);
		
		getContentPane().add(cardNum);
		
		getContentPane().add(cvv);
		
		expiryDate.setBounds(176, 369, 69, 26);
		getContentPane().add(expiryDate);
		
		JLabel currentFeeLbl = new JLabel("Current Fee: $");
		currentFeeLbl.setBounds(41, 246, 107, 20);
		getContentPane().add(currentFeeLbl);
		
		currentFee.setEditable(false);
		currentFee.setBounds(144, 246, 69, 24);
		getContentPane().add(currentFee);
		addressLbl.setBounds(41, 199, 69, 20);
		
		getContentPane().add(addressLbl);
		
	}
	
	public void addSubmitListener(ActionListener al)  {
    	submit.addActionListener(al);
    	submit.setActionCommand("addSubmit");
	}
	
	public String getTypes() {
		return (String) typeBox.getSelectedItem();
	}
	
	public int getBed() {
		return Integer.parseInt((String) bedBox.getSelectedItem());
	}
	
	public int getBath() {
		return Integer.parseInt((String)bathBox.getSelectedItem());
	}
	
	public String getCity() {
		return (String) cityBox.getSelectedItem();
	}
	
	public String getAddress() {
		return address.getText();
	}
	
	public String getHolderName()  {
		return holderName.getText();
	}
	
	public String getCardNum()  {
		return cardNum.getText();
	}
	
	public String getExpiryDate()  {
		return (String) expiryDate.getValue();
	}
	
	public String getCvv()  {
		return cvv.getText();
	}
	
	public void setCurrentFee(Double fee) {
		currentFee.setText(Double.toString(fee));
	}
	
	public boolean getFurnished() {
        if (group.getSelection().getActionCommand() == "Yes") {
        	return true;
        } else if (group.getSelection().getActionCommand() == "No") {
        	return false;
        }
		return false;
    }
}