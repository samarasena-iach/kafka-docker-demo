package com.samiach.kafkadockerdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerClass {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerClass.class);

    @KafkaListener(topics = "user")
    public void consumeMessage(String message) {
        logger.info(String.format("************* Consumer just received the message -> " + message));
    }
}
