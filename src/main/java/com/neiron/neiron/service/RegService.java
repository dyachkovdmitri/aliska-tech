package com.neiron.neiron.service;

import com.neiron.neiron.entities.Customer;
import com.neiron.neiron.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@Service
public class RegService {
    @Autowired
    MailSender mailSender;


    @Autowired
    CustomerRepo customerRepo;


    public String registerNewCustomer(String word, Long customerAliskaId) {
        Customer customer = customerRepo.findById(customerAliskaId);
        word = word.trim();
        try{
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("aliska@d.ru");
        mailMessage.setTo("hi_dmitro@rambler.ru");
        mailMessage.setSubject("Привет, "+customer.getName()+", это Алиска! Приятно познакомиться! Если я не узнаю тебя, введи этот номер в окно диалога в следующий раз : " +customer.getId());
        mailMessage.setText("Привет");
        mailSender.send(mailMessage);
            customer.setEmail(word);
            customer.addAliskaMonolog("<div> "+word+"</div>");
            customer.addAliskaMonolog("<div> Приятно познакомиться! На "+word+" я отправила уникальный номер. В следующий раз, если я тебя не узнаю просто введи его сюда. Или снова напиши свою почту и я отправлю тебе его снова.</div>");
            customerRepo.saveAndFlush(customer);
        } catch (Exception e){
            customer.addAliskaMonolog("<div>На "+word+" не удалось отправить письмо</div>");
            customerRepo.saveAndFlush(customer);
        }
        return "жопа";

    }
}

