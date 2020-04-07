package com.richard.danis.www.sandbox.hibernate.init;

import com.richard.danis.www.sandbox.hibernate.model.Person;
import com.richard.danis.www.sandbox.hibernate.repository.PersonRepository;
import com.richard.danis.www.sandbox.security.model.AuthenticationGroup;
import com.richard.danis.www.sandbox.security.repository.AuthenticationGroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@Configuration
public class DataPopulator {

    private final Logger LOGGER = LoggerFactory.getLogger(DataPopulator.class);

    private PasswordEncoder passwordEncoder;
    private PersonRepository personRepository;
    private AuthenticationGroupRepository groupRepository;

    public DataPopulator(PasswordEncoder passwordEncoder,
                         PersonRepository personRepository,
                         AuthenticationGroupRepository groupRepository) {
        this.passwordEncoder = passwordEncoder;
        this.personRepository = personRepository;
        this.groupRepository = groupRepository;
    }

    @PostConstruct
    public void populateData() {
        Person person = new Person();
        person.setUserName("fruzsi");
        person.setPassword(passwordEncoder.encode("1234"));
        person.setFullName("TestFruzsi");
        personRepository.save(person);
        LOGGER.info("Person saved: {}", person);

        Person person1 = new Person();
        person1.setUserName("user");
        person1.setPassword(passwordEncoder.encode("1234"));
        person1.setFullName("TestUser");
        personRepository.save(person1);
        LOGGER.info("Person1 saved: {}", person1);

        AuthenticationGroup authenticationGroup = new AuthenticationGroup();
        authenticationGroup.setAuthGroup("USER");
        authenticationGroup.setAuthGroup("ADMIN");
        authenticationGroup.setPersonName("fruzsi");
        groupRepository.save(authenticationGroup);
        LOGGER.info("Group added to person: {}", authenticationGroup);

        AuthenticationGroup authenticationGroup1 = new AuthenticationGroup();
        authenticationGroup1.setAuthGroup("USER");
        authenticationGroup1.setPersonName("TestUser");
        groupRepository.save(authenticationGroup1);
        LOGGER.info("Group1 added to person: {}", authenticationGroup1);
    }
}
