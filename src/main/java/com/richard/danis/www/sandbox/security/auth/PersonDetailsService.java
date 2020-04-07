package com.richard.danis.www.sandbox.security.auth;

import com.richard.danis.www.sandbox.hibernate.repository.PersonRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonDetailsService implements UserDetailsService {

    private PersonRepository personRepository;

    public PersonDetailsService(PersonRepository personRepository) {
        super();
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return personRepository.findByUserName(userName)
                               .map(PersonPrincipal::new)
                               .orElseThrow(() -> new UsernameNotFoundException("User name not found exception: " + userName));
    }
}
