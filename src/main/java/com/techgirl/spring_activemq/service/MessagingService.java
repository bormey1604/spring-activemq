package com.techgirl.spring_activemq.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessagingService {

    private final JmsTemplate jmsTemplate;

    @Value("${spring.activemq.queue-name}")
    private String destination;

    public MessagingService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String message) {
        jmsTemplate.convertAndSend(destination, message);
    }
}
