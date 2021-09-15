package com.project.backend.Email.Services.Impl;

import com.project.backend.Email.Email;
import com.project.backend.Email.Services.ISendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendEmailServiceImpl implements ISendEmailService {

    private String myEmail = "lahcenhayane@gmail.com";

    @Autowired
    private JavaMailSender mailSender;

//    @Async
    @Override
    public void SendMailUsernamePassword(Email email){
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(myEmail);
            mimeMessageHelper.setTo(email.getEmail());
            mimeMessageHelper.setSubject(email.getSubject());
            mimeMessageHelper.setText(email.getText());

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
