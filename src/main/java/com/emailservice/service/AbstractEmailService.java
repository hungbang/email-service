package com.emailservice.service;

import com.emailservice.model.EmailContent;
import com.emailservice.model.MailContent;
import com.emailservice.model.MailHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.mail.MessagingException;


public abstract class AbstractEmailService {

    public static final Logger LOGGER = LoggerFactory.getLogger(AbstractEmailService.class);

    @Autowired
    private EmailService emailService;

    @Autowired
    @Qualifier("velocityEmailTemplate")
    public EmailTemplateHelper emailTemplateHelper;

    public void sendMail(final MailContent mailContent) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    emailService.sendMail(mailContent, false);
                } catch (MessagingException e) {
                    LOGGER.error("Error occurs when sending email.", e.getMessage());
                }
            }
        };
        thread.start();
    }

    public void sendMail(final EmailContent mailContent, final MailHeader mailHeader) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    emailService.sendMail(mailContent, mailHeader, false);
                } catch (MessagingException e) {
                    LOGGER.error("Error occurs when sending email.", e.getMessage());
                }
            }
        };
        thread.start();
    }


}
