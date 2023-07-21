package com.samiach.kafkadockerdemo.controller;

import com.samiach.kafkadockerdemo.service.ProducerClass;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class MessagingController {

    private final ProducerClass producer;

    public MessagingController(ProducerClass producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public String sendMessage(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
        return "Published successfully";
    }

    @Bean
    public NewTopic adviceTopic() {
        return new NewTopic("user", 3, (short) 1);
    }

}
