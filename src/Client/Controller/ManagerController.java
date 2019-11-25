package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Client.Communication;
import Client.Manager;
import Client.SummaryReport;
import Client.View.ManagerMenuView;
import Client.View.SummaryReportView;

public class ManagerController implements ActionListener
{
	private ManagerMenuView managerView;
	private Manager manager;
	private SummaryReportView summary;
	
	public ManagerController (Manager m)
	{
		managerView = new ManagerMenuView();
		managerView.setVisible(true);
		manager = m;
		addListeners();
	}
	
	private void addListeners ()
	{
		managerView.addChangeFeeListener(this);
		managerView.addChangeStatusListener(this);
		managerView.addGetUserInfoListener(this);
	}
	
	private void changeFee ()
	{
		Communication c = Communication.getInstance();
		try {
			c.sendString("change fee");
			Double newFee = managerView.getNewFee(); //TODO
			c.sendString(newFee.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch (e.getActionCommand())
		{
		case "change fee":
			changeFee();
			break;
		case "change status":
			break;
		case "getInfo":
			getReport();
			break;
		case "closeReport":
			summary.setVisible(false);
			break;
		}
		
	}

	private void getReport() 
	{
		Communication c = Communication.getInstance();
		try {
			c.sendString("get report");
			SummaryReport report = c.getReport();
			summary = new SummaryReportView();
			summary.setNumActiveList(report.getTotalActive());
			summary.setNumHouseList(report.getTotalListed());
			summary.setNumHouseRent(report.getTotalRented());
			summary.setVisible(true);
			summary.addCloseListener(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}