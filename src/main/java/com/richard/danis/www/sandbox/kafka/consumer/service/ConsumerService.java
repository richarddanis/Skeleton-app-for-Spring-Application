package com.richard.danis.www.sandbox.kafka.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Profile("kafka")
public class ConsumerService {

    private final Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "testTopic", groupId = "test")
    public void listen(String message) {
        LOGGER.info("Received Message in group test: {}", message);
    }
}
