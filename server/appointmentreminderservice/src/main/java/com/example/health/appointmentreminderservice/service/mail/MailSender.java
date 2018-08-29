package com.example.health.appointmentreminderservice.service.mail;

import com.example.health.appointmentreminderservice.service.control.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

public class MailSender {

    private final JavaMailSender javaMailSender;

    @Autowired
    public MailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String receiverEmail, String startTime) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        mimeMessageHelper.setTo(receiverEmail);
        mimeMessageHelper.setSubject("Reminder about your appointment");
        mimeMessageHelper.setText("Hello %s. This is a reminder for your appointment at" +
        String.format("date %s", startTime));

        javaMailSender.send(mimeMessage);
    }
}
