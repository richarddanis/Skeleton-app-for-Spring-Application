package com.richard.danis.www.sandbox.kafka.init;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.Collections;


/**
 * Topic configuration to Kafka.
 */
@Configuration
@Profile("kafka")
@EnableConfigurationProperties
public class TopicConfiguration {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    private KafkaProperties kafkaProperties;

    public TopicConfiguration(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        return new KafkaAdmin(Collections.singletonMap(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress));
    }

    @Bean
    public NewTopic topic() {
        KafkaProperties.Topics topic = kafkaProperties.getTopics().stream().findFirst().orElseThrow(
                () -> new IllegalArgumentException("KafkaProperties should be configure"));
        String topicName = topic.getName();
        int partitionNumber = topic.getPartitionNumber();
        short replicationFactor = topic.getReplicationFactor();
        return new NewTopic(topicName, partitionNumber, replicationFactor);
    }
}
