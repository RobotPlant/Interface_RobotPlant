package com.RobotPlant.SerialTest;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//first from, to, subject, & text values are set

public class SendMail {
    private String from;
    private String to;
    private String subject;
    private String text;

    public SendMail(String from, String to, String subject, String text) {
            this.from = from;
            this.to = to;
        this.subject = subject;
            this.text = text;
    }

    // send method is called in the end
    public void send() throws MessagingException {

        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp"); //define protocolo de envio como SMTP
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.host", "smtp.gmail.com"); //server SMTP do GMAIL
		props.put("mail.smtp.auth", "true"); //ativa autenticacao
		props.put("mail.smtp.user", from); //usuario ou seja, a conta que esta enviando o email (tem que ser do GMAIL)
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", "465"); //porta
		props.put("mail.smtp.socketFactory.port", "465"); //mesma porta para o socket
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		SimpleAuth auth = null;
		auth = new SimpleAuth ("joao.junior.11411@gmail.com","1993280166dhuly");

	    Session session = Session.getDefaultInstance(props,auth);
	    session.setDebug(true);

	    InternetAddress fromAddress = null;
	    InternetAddress toAddress = null;
	    Transport transport = session.getTransport("smtp");
	    transport.connect();
	    try {
	        Message simpleMessage = new MimeMessage(session);
	        fromAddress = new InternetAddress(from);
	        toAddress = new InternetAddress(to);
	        simpleMessage.setFrom(fromAddress);
	        simpleMessage.setRecipient(Message.RecipientType.TO, toAddress);
	        simpleMessage.setSubject(subject);
	        simpleMessage.setText(text);

	        transport.connect("smtp.gmail.com", "1993280166dhuly");
	        simpleMessage.saveChanges();
	        transport.sendMessage(simpleMessage,
	                simpleMessage.getAllRecipients());
	        transport.close();
	        System.out.println("Voila!");
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    } finally {
	        transport.close();
	    }
     }
    public static void main(String[] args) {
		SendMail mail = new SendMail("joao.junior.11411@gmail.com","joaodjuniorec@gmail.com",
										"Teste", "Teste" );

		try {
			mail.send();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 }
