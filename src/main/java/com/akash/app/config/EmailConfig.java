package com.akash.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class EmailConfig {
	
	@Bean
    public SimpleMailMessage emailTemplate()
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("user@gmail.com");
        message.setFrom("akash.band@gmail.com");
        message.setSubject("Email Verification");
        message.setText("Default text");
        return message;
    }
}
