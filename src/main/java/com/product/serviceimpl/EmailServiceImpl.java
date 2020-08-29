package com.product.serviceimpl;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64;
import com.product.service.EmailService;

import lombok.Data;

@Data
@Service("EmailService")
public class EmailServiceImpl implements EmailService{

	
//	public static void main(String[] args) {
//		new EmailServiceImpl().sentEmail("smtp.gmail.com"	, "587", true, true, "mkumaranbeat@gmail.com", "macINFO000", "kumaranmani92@gmail.com", "Regd: Invoice", "Hi lol"+" greetings");
//	}
	@Override
	public boolean sentEmail(String host,String port,boolean auth, boolean tlsEnable, String from,String password, String to, String sub,String msg) {
 
		Properties props = new Properties();
		 props.put("mail.smtp.auth", Boolean.toString(auth));
		 props.put("mail.smtp.starttls.enable", Boolean.toString(tlsEnable)); 
		 props.put("mail.smtp.host", host);
		 props.put("mail.smtp.port", port);

		 String username = from; 
		 Session session = Session.getInstance(props,
		 new javax.mail.Authenticator() {
			 protected PasswordAuthentication getPasswordAuthentication() {
			 return new PasswordAuthentication(username, password);
			 }
		 });
		try {
			 Message message = new MimeMessage(session);
			 message.setFrom(new InternetAddress(from));
			 message.setRecipients(Message.RecipientType.TO,
			 InternetAddress.parse(to));
			 message.setSubject(sub);
			 
			 
			 BodyPart messageBodyPart = new MimeBodyPart();
			 //message.setText(msg);
			 messageBodyPart.setText(msg);
			 Multipart multipart = new MimeMultipart();
			 multipart.addBodyPart(messageBodyPart);
			 
			 messageBodyPart = new MimeBodyPart();
			 String filename = "Invoice.pdf";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);
	         
	         message.setContent(multipart);
			 
			 Transport.send(message);
			 return true;
		} catch (MessagingException e) {
			System.err.println(e.getMessage());
			return false;
		 }
	 }
}
