package com.richard.danis.www.sandbox.rest.controller;

import com.richard.danis.www.sandbox.hibernate.controller.PersonController;
import com.richard.danis.www.sandbox.rest.eventlistener.SomethingHappenedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EventPublisherController {

    private final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
    private ApplicationEventPublisher eventPublisher;

    public EventPublisherController(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostMapping("/event/publish")
    public ResponseEntity<String> registerUser(HttpServletRequest request) {
        try {
            String appUrl = request.getContextPath();
            eventPublisher.publishEvent(new SomethingHappenedEvent(request.getLocale(), appUrl));
            LOGGER.info("Event published.");
        } catch (Exception e) {
            LOGGER.error("Something went wrong: {}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
