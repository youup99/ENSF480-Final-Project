package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Client.Communication;
import Client.View.RenterMenuView;
import Client.View.RenterPropertyView;
import Functionality.Property;

public class GuestController implements GeneralRenterController, ActionListener
{
	private SearchController search;
	private RenterMenuView renterView;
	private PropertyController propertyC;
	private RenterPropertyView propView;
	private ArrayList<Property> searchResults = null;
	private String[][] dataa;
	
	public GuestController ()
	{
		renterView = new RenterMenuView ();
		renterView.setVisible(true);
		addListenersToClass();
	}

	private void addListenersToClass ()
	{
		renterView.addSearchListener (this);
		renterView.addExitListener(this);
	}

	@Override
	public void getSearchData(Property p) 
	{
		Communication ctos = Communication.getInstance();
		try {
			ctos.sendString("get properties");
			ctos.sendProperty(p);
			searchResults = ctos.getProperties();
			if(searchResults == null)
				throw new NullPointerException();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setData();
		
		propView = new RenterPropertyView(dataa);
		propView.setGuestController(this);
		propView.setDisplay(searchResults);
		propView.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand().equals("exit"))
		{
			System.exit(1);
		}
		if (e.getActionCommand().equals("exit"))
		{
			System.exit(1);
		}
		else if(e.getActionCommand().equals("search")) 
		{
			search = new SearchController (this);

		}
		else if (e.getActionCommand().equals("send email"))
		{
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
	        properties.put("mail.smtp.host", "smtp.gmail.com");
	        properties.put("mail.smtp.port", "587");
	        
	        String myAccountEmail = "ensf480@gmail.com";
	        String password = "fallensf480";

	        
	        Session session = Session.getInstance(properties, new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(myAccountEmail, password);
	            }
	        });
	        
	        Message message = prepareMessage(session, propView.getEmailView().getFrom(), propView.getSelectedProperty().getLandlordEmail());
			
	        try {
				Transport.send(message);
			} catch (MessagingException me) {
				me.printStackTrace();
			}
	        System.out.println("Message sent successfully!");
		}
	}
	
	public Message prepareMessage(Session session, String myAccountEmail, String recepient){
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(propView.getEmailView().getSubject());
            message.setText(propView.getEmailView().getEmail());
            return message;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
	
	public void setData() {
		dataa = new String[searchResults.size()][6];
		for(int i = 0; i < searchResults.size(); i++) {
			   for(int j = 0; j < 6; j++) {
				    if (j == 0) {
					   dataa[i][j] = Integer.toString(searchResults.get(i).getID());
	       			} else if (j == 1) {
	       			   dataa[i][j] = searchResults.get(i).getType();
	       		    } else if (j == 2) {
	       			   dataa[i][j] = Integer.toString(searchResults.get(i).getNumOfBedrooms());
	       		    } else if (j == 3) {
	       			   dataa[i][j] = Integer.toString(searchResults.get(i).getNumOfBathrooms());
	       		    } else if (j == 4) {
	       			   if (searchResults.get(i).isFurnished() == true) {
	       				   dataa[i][j] = "Yes";
	       			   } else if (searchResults.get(i).isFurnished() == false) {
	       				   dataa[i][j] = "No";
	       			   }
	       		    } else if (j == 5) {
	       			   dataa[i][j] = searchResults.get(i).getCityQuadrant();
	       		    }
	       	   }
	       }	
	}

}
