package com.richard.danis.www.sandbox.hibernate.service;

import com.richard.danis.www.sandbox.hibernate.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends AbstractGenericBusinessEntityServiceImpl<Person, Long> {

    protected PersonService(JpaRepository<Person, Long> repository) {
        super(repository);
    }
}
