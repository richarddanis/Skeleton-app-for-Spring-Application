package com.richard.danis.www.sandbox.security.auth;

import com.richard.danis.www.sandbox.hibernate.model.Person;
import com.richard.danis.www.sandbox.hibernate.repository.PersonRepository;
import com.richard.danis.www.sandbox.security.model.AuthenticationGroup;
import com.richard.danis.www.sandbox.security.repository.AuthenticationGroupRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDetailsService implements UserDetailsService {

    private PersonRepository personRepository;
    private AuthenticationGroupRepository groupRepository;

    public PersonDetailsService(PersonRepository personRepository,
                                AuthenticationGroupRepository groupRepository) {
        super();
        this.personRepository = personRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Person person = personRepository.findByUserName(userName)
                                        .orElseThrow(() -> new UsernameNotFoundException("User name not found exception: " + userName));
        List<AuthenticationGroup> groupList = groupRepository.findByPersonName(userName);
        return new PersonPrincipal(person, groupList);
    }
}
