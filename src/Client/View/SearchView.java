import java.util.Enumeration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SearchView extends JFrame{
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
		setTitle("Search");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Type");
		lblNewLabel.setBounds(41, 19, 69, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("# of Bedrooms");
		lblNewLabel_1.setBounds(41, 55, 107, 20);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("# of bathrooms");
		lblNewLabel_2.setBounds(41, 91, 123, 20);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Furnished");
		lblNewLabel_3.setBounds(41, 127, 69, 20);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("City quadrant");
		lblNewLabel_4.setBounds(41, 163, 107, 20);
		getContentPane().add(lblNewLabel_4);
		
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
	
	public boolean getSelectedButtonText() {
        if (group.getSelection().getActionCommand() == "Yes") {
        	return true;
        } else if (group.getSelection().getActionCommand() == "No") {
        	return false;
        }
    }
	
}