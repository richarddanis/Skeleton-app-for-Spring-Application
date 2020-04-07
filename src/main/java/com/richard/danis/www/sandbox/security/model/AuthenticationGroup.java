package com.richard.danis.www.sandbox.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class AuthenticationGroup {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "PERSON_NAME")
    private String personName;

    @Column(name = "AUTH_GROUP")
    private String authGroup;

    public AuthenticationGroup() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getAuthGroup() {
        return authGroup;
    }

    public void setAuthGroup(String authGroup) {
        this.authGroup = authGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthenticationGroup that = (AuthenticationGroup) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(personName, that.personName) &&
                Objects.equals(authGroup, that.authGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personName, authGroup);
    }
}
