package com.richard.danis.www.sandbox.kafka.init;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO to store topic config.
 */
@ConfigurationProperties(prefix = "kafka")
@Component
public class KafkaProperties {

    private List<Topics> topics = new ArrayList<>();

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }

    public static class Topics {
        private String name;
        private int partitionNumber;
        private short replicationFactor;

        public short getReplicationFactor() {
            return replicationFactor;
        }

        public void setReplicationFactor(short replicationFactor) {
            this.replicationFactor = replicationFactor;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPartitionNumber() {
            return partitionNumber;
        }

        public void setPartitionNumber(int partitionNumber) {
            this.partitionNumber = partitionNumber;
        }
    }
}
