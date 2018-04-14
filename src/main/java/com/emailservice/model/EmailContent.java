package com.emailservice.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KAI on 4/14/18.
 */
public class EmailContent {
    private String mailBody;
    private List<MailAttachment> mailAttachments = new ArrayList();

    public EmailContent() {
    }

    public String getMailBody() {
        return this.mailBody;
    }

    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    public List<MailAttachment> getMailAttachments() {
        return this.mailAttachments;
    }

    public void setMailAttachments(List<MailAttachment> mailAttachments) {
        this.mailAttachments = mailAttachments;
    }
}