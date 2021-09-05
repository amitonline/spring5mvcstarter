package com.truelogic.spring5.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
 

@EnableAsync
@Service("mailService")
public class MailerService
{
	
    @Autowired
    private JavaMailSender mailSender;
     
 
    /**
     * This method will send compose and send the message
     * */
    @Async
    public void sendMail(String fromName, String fromEmail, String to, String subject, String body)
    {
     
        try {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
        
        helper.setFrom(fromName + " <" + fromEmail + ">");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true);
        mailSender.send(mimeMessage);
        
	    } catch (Exception ex) {
	    	String err = ex.getMessage();
	    }

    }
    
   
 
}