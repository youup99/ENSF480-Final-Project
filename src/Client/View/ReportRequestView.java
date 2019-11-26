package Client.View;

import javax.swing.*;
import javax.swing.text.DateFormatter;

import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportRequestView extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton generateReport = new JButton("Generate Report");
	private JFormattedTextField startDate = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
	private JFormattedTextField endDate = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
	
	public ReportRequestView() {
		getContentPane().setBackground(new Color(230, 230, 250));
		getContentPane().setLayout(null);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(33, 16, 78, 20);
		getContentPane().add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(33, 69, 69, 20);
		getContentPane().add(lblEndDate);
		
		generateReport.setBounds(52, 129, 147, 29);
		getContentPane().add(generateReport);
		
		startDate.setBounds(114, 13, 93, 26);
		getContentPane().add(startDate);

		startDate.setValue(new Date());
		startDate.setColumns(10);
		
		endDate.setBounds(114, 66, 93, 26);
		getContentPane().add(endDate);
		
		endDate.setValue(new Date());
		endDate.setColumns(10);
		
		setTitle("Summary Report Request Form");
	}
	
	public void addGenerateReportListener(ActionListener al)  {
    	generateReport.addActionListener(al);
    	generateReport.setActionCommand("generateReport");
	}
	
	public String getStartDate()  {
		return (String) startDate.getValue();
	}
	
	public String getEndDate()  {
		return (String) endDate.getValue();
	}
}