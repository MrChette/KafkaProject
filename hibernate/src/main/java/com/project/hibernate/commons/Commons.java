package com.project.hibernate.commons;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Commons {
	
	public String generateMessage(String template, Map<String, String> parameters) {
        String message = template;

        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            message = message.replace(":" + entry.getKey(), entry.getValue());
        }

        return message;
    }

}
