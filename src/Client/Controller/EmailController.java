package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import Client.Property;
import Client.View.EmailView;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailController {
	private Property property;
	private EmailView emailView;
	
	class EmailListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
	        properties.put("mail.smtp.host", "smtp.gmail.com");
	        properties.put("mail.smtp.port", "587");
	        
	        Session session = Session.getInstance(properties);
	        
	        Message message = prepareMessage(session, emailView.getFrom(), property.getLandlordEmail());
			
	        try {
				Transport.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
	        System.out.println("Message sent successfully!");
		}
	}
	
	public Message prepareMessage(Session session, String myAccountEmail, String recepient){
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(emailView.getSubject());
            message.setText(emailView.getEmail());
            return message;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
	
    public void addListenersToView(){
        
    }
}
