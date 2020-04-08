package com.richard.danis.www.sandbox.rest.eventlistener;

import com.richard.danis.www.sandbox.hibernate.controller.PersonController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class SomethingHappenedListener implements ApplicationListener<SomethingHappenedEvent> {

    private final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    @Override
    public void onApplicationEvent(SomethingHappenedEvent event) {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("Event called: {}", event.getLocale());
    }
}
