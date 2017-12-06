package com.neiron.neiron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@Service
public class RegService {
    static final String ENCODING = "UTF-8";

    public String registerNewCustomer(String word) throws MessagingException {
        try {
            word = "hi_dmitro@rambler.ru";
            String smtpHost = "smtp.gmail.com";
            String login = "dyachkovdmitri@gmail.com";
            String password = "Shikaka1";
            String smtpPort = "587";
            Authenticator auth = new MyAuthEmail(login, password);

            Properties props = System.getProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.debug", "true");
            props.put("mail.smtp.port", smtpPort);
            props.put("mail.smtp.host", smtpHost);
            props.put("mail.mime.charset", ENCODING);

//            Properties props = System.getProperties();
//            props.put("mail.pop3.port", popPort);
//            props.put("mail.pop3.host", smtpHost);
//            //props.put("mail.smtp.auth", "true");
//            props.put("mail.mime.charset", ENCODING);
            Session session = Session.getDefaultInstance(props, auth);

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("d@d.ru"));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(word.trim()));
            msg.setSubject("sdf");
            msg.setText("sdf");
            Transport.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "dsf";

    }
}