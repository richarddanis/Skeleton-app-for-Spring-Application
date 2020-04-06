package com.richard.danis.www.sandbox.kafka.controller;

import com.richard.danis.www.sandbox.kafka.producer.service.ProducerService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("kafka")
public class KafkaMessageController {

    private ProducerService producerService;

    public KafkaMessageController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        producerService.sendMessage(message);
        return new ResponseEntity<>("Message has sent.", HttpStatus.OK);
    }
}
