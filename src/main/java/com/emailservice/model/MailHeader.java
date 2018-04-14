package com.emailservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KAI on 4/14/18.
 */
public class MailHeader implements Serializable {
    private static final long serialVersionUID = 2567360127771251402L;
    private String subject;
    private String from;
    private String mailContentType = "text/html";
    private List<String> to = new ArrayList();
    private List<String> cc = new ArrayList();
    private List<String> bcc = new ArrayList();

    public MailHeader() {
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void addTo(String to) {
        this.getTo().add(to);
    }

    public void addCC(String cc) {
        this.getCc().add(cc);
    }

    public void addBcc(String bcc) {
        this.getBcc().add(bcc);
    }

    public List<String> getTo() {
        return this.to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public List<String> getCc() {
        return this.cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public List<String> getBcc() {
        return this.bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMailContentType() {
        return this.mailContentType;
    }

    public void setMailContentType(String mailContentType) {
        this.mailContentType = mailContentType;
    }
}