package com.bayram.service.user.Imp;

import java.util.Date;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.bayram.web.dto.Mail;

@Service
public class MailService {
	
	
	
	public String sendToGmailAccount(Mail mail) {
		

		try {

			Properties props = new Properties();
			props.put("mail.smtp.host", "localhost");
			props.put("mail.smtp.port", "25");
			Session session = Session.getDefaultInstance(props, null);
			session.setDebug(false);
			
			Message msg = new MimeMessage(session);
			msg.setContent(mail.getModel().get("resetUrl"), "text/html; charset=utf-8");
			msg.setFrom(new InternetAddress(mail.getFrom()));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail.getTo(),false));
			msg.setSubject(mail.getSubject());
			msg.setSentDate(new Date());
			Transport.send(msg);
			
			return "Mail sended succesfully";

		} catch (Exception ex) {
			return "Mail sending has a error: "+ex.getMessage();
		}
	}
	
	
}
