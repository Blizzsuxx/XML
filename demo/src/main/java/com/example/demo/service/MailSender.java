package com.example.demo.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class MailSender {
    @Autowired
    public MailSender() {

    }

    public Boolean sendEmail(String address, ByteArrayOutputStream text) {
        try {
            sendmail(address, text);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("doktorski.sistem@gmail.com");
        mailSender.setPassword("IsaMrs123");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    public static void sendmail(String sendT0, ByteArrayOutputStream text) throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {

                return new javax.mail.PasswordAuthentication("doktorski.sistem@gmail.com", "IsaMrs123");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("doktorski.sistem@gmail.com", false));

        // msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendT0));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mahajiraaji@gmail.com"));

        msg.setSubject("Sistem Za Vakcinaciju");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("Uspesno ste se prijavili za vakcinaciju\nU prilogu se nalazi vasa prijava");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        
        DataSource dataSource = new ByteArrayDataSource(text.toByteArray(), "application/pdf");
        MimeBodyPart pdfBodyPart = new MimeBodyPart();
        pdfBodyPart.setDataHandler(new DataHandler(dataSource));
        pdfBodyPart.setFileName("dokument.pdf");

        multipart.addBodyPart(pdfBodyPart);
        msg.setContent(multipart);
        

        Transport.send(msg);

    }
}