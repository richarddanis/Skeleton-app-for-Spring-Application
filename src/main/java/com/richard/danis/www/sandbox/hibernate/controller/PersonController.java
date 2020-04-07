package com.richard.danis.www.sandbox.hibernate.controller;

import com.richard.danis.www.sandbox.hibernate.model.Person;
import com.richard.danis.www.sandbox.hibernate.service.PersonService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find person by id", response = Person.class, responseContainer = "object")
    public ResponseEntity<Person> findById(@PathVariable long id) {
        try {
            Person person = personService.findById(id);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            LOGGER.warn("Person element not found in database: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error("Unrecognized error for find person by id: {} , exception: {}", id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Iterable<Person> allPerson() {
        return personService.findAll();
    }
}
