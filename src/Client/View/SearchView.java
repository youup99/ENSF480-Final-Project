package Client.View;

import java.util.Enumeration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SearchView extends JFrame{
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
	
	public SearchView() {
		setSize(421, 308);
		getContentPane().setBackground(new Color(230, 230, 250));
		setTitle("Search");
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
		
		submit.setBounds(142, 199, 115, 29);
		getContentPane().add(submit);
		
	}
	
	public void addSubmitListener(ActionListener al)  {
    	submit.addActionListener(al);
    	submit.setActionCommand("searchSubmit");
	}
	
	public String getTypes() {
		return (String) typeBox.getSelectedItem();
	}
	
	public String getBed() {
		return (String) bedBox.getSelectedItem();
	}
	
	public String getBath() {
		return (String) bathBox.getSelectedItem();
	}
	
	public String getCity() {
		return (String) cityBox.getSelectedItem();
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