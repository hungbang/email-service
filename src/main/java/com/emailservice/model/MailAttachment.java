package com.emailservice.model;

import java.io.File;

/**
 * Created by KAI on 4/14/18.
 */
public class MailAttachment {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getAttachmentFile() {
        return attachmentFile;
    }

    public void setAttachmentFile(File attachmentFile) {
        this.attachmentFile = attachmentFile;
    }

    private File attachmentFile;

}
