import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SearchView extends JFrame{
	private String[] types = {"Apartment", "Attached House", "Detached House", "Townhouse"};
	private String[] nums = {"1", "2", "3", "4", "5"};
	private String[] quadrant = {"SW", "NW", "SE", "NE"};
	
	public SearchView() {
		setTitle("Search");
		getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox(types);
		comboBox.setBounds(157, 16, 196, 26);
		getContentPane().add(comboBox);
		
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
		
		JComboBox comboBox_1 = new JComboBox(nums);
		comboBox_1.setBounds(157, 52, 36, 26);
		getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox(nums);
		comboBox_2.setBounds(157, 88, 36, 26);
		getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox(quadrant);
		comboBox_3.setBounds(157, 160, 56, 26);
		getContentPane().add(comboBox_3);
		
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.setBounds(156, 127, 163, 29);
		buttonGroup.add(new JRadioButton('Label1', false));
		buttonGroup.add(new JRadioButton('Label2', true));

	}
}