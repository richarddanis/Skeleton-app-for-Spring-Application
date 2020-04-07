package com.richard.danis.www.sandbox.security.auth;

import com.richard.danis.www.sandbox.hibernate.model.Person;
import com.richard.danis.www.sandbox.security.model.AuthenticationGroup;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PersonPrincipal implements UserDetails {

    private Person person;
    private List<AuthenticationGroup> authenticationGroups;

    public PersonPrincipal(Person person, List<AuthenticationGroup> authenticationGroups) {
        super();
        this.person = person;
        this.authenticationGroups = authenticationGroups;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authenticationGroups.stream()
                                   .map(auth -> new SimpleGrantedAuthority(auth.getAuthGroup()))
                                   .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
