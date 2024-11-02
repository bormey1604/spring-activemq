package com.techgirl.spring_activemq.controller;

import com.techgirl.spring_activemq.model.Message;
import com.techgirl.spring_activemq.service.MessagingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessagingController {

    private final MessagingService messagingService;

    public MessagingController(MessagingService messagingService) {
        this.messagingService = messagingService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody Message message) {
        messagingService.sendMessage(message.toString());
        return "Message sent successfully";
    }

}
