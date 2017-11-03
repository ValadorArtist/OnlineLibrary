package spring.mvc.library.classes;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


public class Email {
	
	private	static final String host = "smtp.wp.pl";	
	private	static final String user = "valador1993@wp.pl";
	private static final String pass = "Napoleon1993";
		
	private String to;
	private static final String from = "valador1993@wp.pl";
	private static final String subject = "Account access confirmation";
	private static final String subject2 = "Access Confrimation to Library";
	private	String message = "This is a confirmation link. "
			+ "Go there and enjoy your Library account\n "
			+ "http://localhost:8080/Library/validation?id=";
	private	String message2 = "New user invite you. "
			+ "Click this link to accept his invitation\n "
			+ "http://localhost:8080/Library/inviteValid?who=";
		
	public Email(String to, String code){
		setTo(to);
		setMessage(code);
		sendEmail(1);
	}
	
	public Email(String EmailAddress, String who, String to){
		setTo(EmailAddress);
		setMessage2(who);
		setMessage2("&to=");
		setMessage2(to);
		sendEmail(2);
	}
	
	public void sendEmail(int number){
		
		try{
		boolean sessionDebug = false;
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.startls.required","true");
		
		java.security.Security.getProvider("SunPCSC");
		
		Session mailSession = Session.getDefaultInstance(props, 
			    new javax.mail.Authenticator(){
	        		protected PasswordAuthentication getPasswordAuthentication() {
	        			return new PasswordAuthentication(from, pass);
	        }
		});
		mailSession.setDebug(sessionDebug);
		
		Message msg = new MimeMessage(mailSession);
		msg.setFrom(new InternetAddress(from));
		InternetAddress[] address = {new InternetAddress(to)};
		msg.setRecipients(Message.RecipientType.TO, address);
		msg.setSentDate(new Date());
		if(number==1){
			msg.setSubject(subject);
			msg.setText(message);
		}else{
			msg.setSubject(subject2);
			msg.setText(message2);
		}
		
		
		Transport transport = mailSession.getTransport("smtp");
		transport.connect(host, user, pass);
		Transport.send(msg, msg.getAllRecipients());
		transport.close();
		
		System.out.println("Message sent successfully");
		
		}catch(Exception ex){
			
			System.out.println(ex);
		}

	}
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message += message;
	}
	public String getMessage2() {
		return message2;
	}
	public void setMessage2(String message2) {
		this.message2 += message2;
	}

}
