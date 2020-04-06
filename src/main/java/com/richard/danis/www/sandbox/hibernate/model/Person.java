package com.richard.danis.www.sandbox.hibernate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person implements BusinessEntity<Long>, Serializable {

    @Id
    @GeneratedValue
    @Column(unique = true, name = "ID")
    private Long id;

    @NotBlank
    @Size(max = 1000)
    @Column(unique = true, nullable = false, name = "USER_NAME")
    private String userName;

    @Column(nullable = false, name = "PASSWORD")
    private String password;

    @Column(nullable = false, name = "FULL_NAME")
    private String fullName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    public Person() {
        creationDate = LocalDate.now();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(userName, person.userName) &&
                Objects.equals(password, person.password) &&
                Objects.equals(fullName, person.fullName) &&
                Objects.equals(creationDate, person.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, fullName, creationDate);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
