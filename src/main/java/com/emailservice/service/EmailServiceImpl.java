package com.emailservice.service;

import com.emailservice.model.EmailContent;
import com.emailservice.model.MailContent;
import com.emailservice.model.MailHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by KAI on 4/13/18.
 */
@Component
public class EmailServiceImpl implements EmailService {

    public final static Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(MailContent mailContent, boolean multipart) throws MessagingException {
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage, multipart);
        helper.setFrom(mailContent.getFrom());
        helper.setTo(mailContent.getTo());
        helper.setSubject(mailContent.getSubject());
        helper.setText(mailContent.getText(), true);
        javaMailSender.send(mailMessage);

    }

    @Override
    public void sendMail(EmailContent mailContent, MailHeader mailHeader, boolean multipart) throws MessagingException {
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage, multipart);
        helper.setFrom(mailHeader.getFrom());
        helper.setTo(mailHeader.getTo().toArray(new String[mailHeader.getTo().size()]));
        helper.setSubject(mailHeader.getSubject());
        helper.setText(mailContent.getMailBody(), true);
        mailContent.getMailAttachments().forEach(mailAttachment -> {
            try {
                helper.addAttachment(mailAttachment.getName(), mailAttachment.getAttachmentFile());
            } catch (MessagingException e) {
                LOGGER.error("Could not attach file to mail.");
            }
        });
        javaMailSender.send(mailMessage);
    }
}
