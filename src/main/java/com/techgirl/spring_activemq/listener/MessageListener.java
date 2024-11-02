package com.techgirl.spring_activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @JmsListener(destination = "${spring.activemq.queue-name}")
    public void listen(String message) {
        System.out.println("message = " + message);
    }

}
