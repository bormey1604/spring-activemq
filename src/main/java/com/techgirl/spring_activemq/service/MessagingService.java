package com.techgirl.spring_activemq.service;

import jakarta.jms.Message;
import org.apache.activemq.ScheduledMessage;
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


    public void sendCronScheduledMessage(String content){
        jmsTemplate.execute(session -> {
            Message message = session.createTextMessage(content);
            message.setStringProperty(ScheduledMessage.AMQ_SCHEDULED_CRON, "12 7 * * ?"); // At 11:35 AM daily
            jmsTemplate.convertAndSend(destination, message);
            return message.getJMSMessageID();
        });
    }

    public void sendDelayScheduledMessage(String content){
        jmsTemplate.execute(session -> {
            Message message = session.createTextMessage(content);
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, 10000); // 10 seconds delay
            jmsTemplate.convertAndSend(destination, message);
            return message.getJMSMessageID();
        });
    }
}
