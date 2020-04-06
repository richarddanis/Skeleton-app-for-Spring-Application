package com.richard.danis.www.sandbox.hibernate.service;

import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface GenericBusinessService<T, ID> {

    T get(@NotNull ID id);

    Iterable<T> findAll();

    Iterable<T> findAll(@NotNull Pageable pageable);

    T save(@NotNull @Valid T t);

    void remove(@NotNull T t);

    T findById(@NotNull ID id);
}
