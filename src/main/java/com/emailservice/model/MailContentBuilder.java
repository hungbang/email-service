package com.emailservice.model;

/**
 * Created by KAI on 4/13/18.
 */
public final class MailContentBuilder {
    private String from;
    private String to;
    private String subject;
    private String text;

    private MailContentBuilder() {
    }

    public static MailContentBuilder aMailContent() {
        return new MailContentBuilder();
    }

    public MailContentBuilder withFrom(String from) {
        this.from = from;
        return this;
    }

    public MailContentBuilder withTo(String to) {
        this.to = to;
        return this;
    }

    public MailContentBuilder withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public MailContentBuilder withText(String text) {
        this.text = text;
        return this;
    }

    public MailContent build() {
        MailContent mailContent = new MailContent();
        mailContent.setFrom(from);
        mailContent.setTo(to);
        mailContent.setSubject(subject);
        mailContent.setText(text);
        return mailContent;
    }
}
