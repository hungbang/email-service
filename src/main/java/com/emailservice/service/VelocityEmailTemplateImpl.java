package com.emailservice.service;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.util.Locale;
import java.util.Map;

/**
 * Created by KAI on 4/14/18.
 */
public class VelocityEmailTemplateImpl implements EmailTemplateHelper {

    private static final String DOT = ".";
    private static final String DEFAULT_ENCODING = "UTF-8";

    private VelocityEngine velocityEngine;

    public String getEmailContent(String templatePage, Map<String, Object> modelMap) {
        return VelocityEngineUtils.mergeTemplateIntoString(this.velocityEngine, templatePage, DEFAULT_ENCODING, modelMap);
    }

    //TODO:
    public String getEmailContentWithLocale(String templateLocation, Map<String, Object> model, Locale locale) {
        String template = this.getTemplate(templateLocation, locale);
        String content = null;

        try {
            content = this.getContent(template, model);
        } catch (ResourceNotFoundException var7) {
            content = this.getContent(templateLocation, model);
        }

        return content;
    }

    public String getContent(String templateLocation, Map<String, Object> model) {
        return VelocityEngineUtils.mergeTemplateIntoString(this.velocityEngine, templateLocation, DEFAULT_ENCODING, model);
    }

    private String getTemplate(String templateLocation, Locale locale) {
        StringBuilder templatePrefix = new StringBuilder();
        String[] templateNamePaths = this.getTemplatePaths(templateLocation);
        String fileName = templateNamePaths[0];
        String fileExtension = templateNamePaths[1];
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String variant = locale.getVariant();
        templatePrefix.append(fileName);
        this.appendLanguagePart(templatePrefix, language);
        this.appendLanguagePart(templatePrefix, country);
        this.appendLanguagePart(templatePrefix, variant);
        templatePrefix.append(DOT).append(fileExtension);
        return templatePrefix.toString();
    }

    private void appendLanguagePart(StringBuilder templatePrefix, String part) {
        if (StringUtils.isNotBlank(part)) {
            templatePrefix.append('_').append(part);
        }

    }

    private String[] getTemplatePaths(String templateLocation) {
        int lastDot = templateLocation.lastIndexOf(".");
        String[] paths = new String[]{templateLocation.substring(0, lastDot), templateLocation.substring(lastDot + 1)};
        return paths;
    }

    public VelocityEngine getVelocityEngine() {
        return this.velocityEngine;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }
}
