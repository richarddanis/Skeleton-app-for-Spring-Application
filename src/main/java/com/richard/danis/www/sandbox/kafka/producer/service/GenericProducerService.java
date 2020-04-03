package com.richard.danis.www.sandbox.kafka.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

public abstract class GenericProducerService<K, V> {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private KafkaTemplate<K, V> kafkaTemplate;

    public GenericProducerService(KafkaTemplate<K, V> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(V message) {
        ListenableFuture<SendResult<K, V>> future = kafkaTemplate.send(getTopicName(), message);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<K, V> result) {
                LOGGER.info("Sent message: {} with offset: {}", message, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("Unable to send message: {} due to: {}", message, ex.getMessage());
            }
        });
    }

    protected abstract String getTopicName();
}
