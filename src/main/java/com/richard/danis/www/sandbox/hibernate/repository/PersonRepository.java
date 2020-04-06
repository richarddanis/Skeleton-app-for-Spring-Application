package com.richard.danis.www.sandbox.hibernate.repository;

import com.richard.danis.www.sandbox.hibernate.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
