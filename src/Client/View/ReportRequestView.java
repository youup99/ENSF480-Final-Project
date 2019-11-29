package Client.View;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class ReportRequestView extends JFrame {
	private static final long serialVersionUID = 1L;
	private String[] year = {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"};
	private String[] month = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	private String[] date = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	
	private JButton generateReport = new JButton("Generate Report");
	private JComboBox yearStart = new JComboBox(year);
	private JComboBox monthStart = new JComboBox(month);
	private JComboBox dateStart = new JComboBox(date);
	private final JComboBox yearEnd = new JComboBox(year);
	private final JComboBox monthEnd = new JComboBox(month);
	private final JComboBox dateEnd = new JComboBox(date);

	public ReportRequestView() {
		getContentPane().setBackground(new Color(230, 230, 250));
		getContentPane().setLayout(null);
		setSize(375, 230);
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(33, 16, 78, 20);
		getContentPane().add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(33, 69, 69, 20);
		getContentPane().add(lblEndDate);
		
		generateReport.setBounds(99, 129, 147, 29);
		getContentPane().add(generateReport);
		
		yearStart.setBounds(108, 13, 69, 26);
		getContentPane().add(yearStart);
		
		
		monthStart.setBounds(192, 13, 54, 26);
		getContentPane().add(monthStart);
		
		
		dateStart.setBounds(261, 13, 54, 26);
		getContentPane().add(dateStart);
		yearEnd.setBounds(108, 63, 69, 26);
		
		getContentPane().add(yearEnd);
		monthEnd.setBounds(192, 63, 54, 26);
		
		getContentPane().add(monthEnd);
		dateEnd.setBounds(261, 63, 54, 26);
		
		getContentPane().add(dateEnd);
		
		setTitle("Summary Report Request Form");
	}
	
	public void addGenerateReportListener(ActionListener al)  {
    	generateReport.addActionListener(al);
    	generateReport.setActionCommand("generateReport");
	}
	
	public String getStartYear()  {
		return (String) yearStart.getSelectedItem();
	}
	
	public String getStartMonth() {
		return (String) monthStart.getSelectedItem();
	}
	
	public String getStartDate() {
		return (String) dateStart.getSelectedItem();
	}
	
	public String getEndYear() {
		return (String) yearEnd.getSelectedItem();
	}
	
	public String getEndMonth() {
		return (String) monthEnd.getSelectedItem();
	}
	
	public String getEndDate() {
		return (String) dateEnd.getSelectedItem();
	}
}