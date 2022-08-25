package com.clerk.clerkb.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import com.clerk.clerkb.model.zahtevZaSertifikat.ZahtevZaSertifikat;

@Service
public class MailSender2 {

    public JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("marinaseqrity77711@gmail.com");
        mailSender.setPassword("nqepiemtkkpxtkwe"); //875866 //141041 //win-nqepiemtkkpxtkwe //mac-kuguiwcebhrczzhu

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    public void sendDeclineRequestEmail(ZahtevZaSertifikat resource, String reason) throws XMLDBException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("marinaseqrity77711@gmail.com");
        message.setTo("pera.peric111000@gmail.com");
        message.setSubject("Zahtev za digitalni sertifikat - ODBIJEN");
        message.setText("Postovani " + resource.getPacijent().getIme() +
                ",\n\nObavestavamo Vas da je vas zahtev za digitalni sertifikat odbijen.\n\nRazlog odbijanja zahteva u nastavku.\n\n" + reason);
        getJavaMailSender().send(message);
    }

    public void sendMessage(String adresa, String info) throws XMLDBException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("marinaseqrity77711@gmail.com");
        message.setTo("pera.peric111000@gmail.com");
        message.setSubject("Zahtev za digitalni sertifikat - ODBIJEN");
        message.setText(info);
        getJavaMailSender().send(message);
    }

    public void sendAcceptRequestEmail(String filePath) throws MessagingException, IOException {
        MimeMessage message = getJavaMailSender().createMimeMessage();
        message.setFrom("marinaseqrity77711@gmail.com");
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("pera.peric111000@gmail.com"));
        message.setSubject("Zahtev za digitalni sertifikat - ODOBREN");

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("Postovani,\n\n Obavestavamo Vas da je vas zahtev za digitalni sertifikat odobren. U prilogu mozete videti svoj digitalni sertifikat.\n\n");

        MimeBodyPart attachmentHtmlPart = new MimeBodyPart();
        attachmentHtmlPart.attachFile(new File("src/main/resources/static/" + filePath + ".html"));

        MimeBodyPart attachmentPdfPart = new MimeBodyPart();
        attachmentPdfPart.attachFile(new File("src/main/resources/static/" + filePath + ".pdf"));

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachmentHtmlPart);
        multipart.addBodyPart(attachmentPdfPart);


        message.setContent(multipart);
        getJavaMailSender().send(message);
    }
}
