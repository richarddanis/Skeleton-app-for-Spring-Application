package com.richard.danis.www.sandbox.hibernate.controller;

import com.richard.danis.www.sandbox.hibernate.model.Person;
import com.richard.danis.www.sandbox.hibernate.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController("/person")
public class PersonController {

    private final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostConstruct
    public void init() {
        Person person = new Person();
        person.setName("test");
        Person savedPerson = personService.save(person);
        LOGGER.info("Person saved into database: {}", savedPerson);
    }
}
