package com.emailservice.service;

import com.emailservice.model.EmailContent;
import com.emailservice.model.MailContent;
import com.emailservice.model.MailHeader;

import javax.mail.MessagingException;

/**
 * Created by KAI on 4/13/18.
 */
public interface EmailService {
    void sendMail(MailContent mailContent, boolean multipart) throws MessagingException;

    void sendMail(EmailContent mailContent, MailHeader mailHeader, boolean multipart) throws MessagingException;
}
