package com.richard.danis.www.sandbox.security.repository;

import com.richard.danis.www.sandbox.security.model.AuthenticationGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthenticationGroupRepository extends JpaRepository<AuthenticationGroup, Long> {
    List<AuthenticationGroup> findByPersonName(String personName);
}
