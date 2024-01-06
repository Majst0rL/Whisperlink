package com.whisperlink.whisperlink.services;
import com.whisperlink.whisperlink.models.User;

import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Service
public class EmailService {
    private JavaMailSenderImpl emailSender;

    public EmailService(JavaMailSenderImpl emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(User user, String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(user.getEmail());
        message.setTo(to); //e-mail of recepient
        message.setSubject(subject);
        message.setText(text);

        // Settings for username and password
        emailSender.setUsername(user.getEmail());
        emailSender.setPassword(user.getPassword());

        emailSender.send(message);
    }
}
