package com.emailservice.service;

import java.util.Locale;
import java.util.Map;

/**
 * Created by KAI on 4/14/18.
 */
public interface EmailTemplateHelper {

    String getEmailContent(String template, Map<String, Object> modelMap);
    String getEmailContentWithLocale(String template, Map<String, Object> modelMap, Locale locale);



}
