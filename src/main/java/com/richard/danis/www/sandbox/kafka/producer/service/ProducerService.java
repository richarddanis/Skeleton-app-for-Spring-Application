package com.richard.danis.www.sandbox.kafka.producer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Implement {@link GenericProducerService} for String - String Kafka message send.
 */
@Service
public class ProducerService extends GenericProducerService<String, String> {

    public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        super(kafkaTemplate);
    }

    @Override
    protected String getTopicName() {
        return "testTopic";
    }
}
