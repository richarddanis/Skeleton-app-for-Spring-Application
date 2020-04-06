package com.richard.danis.www.sandbox.hibernate.service;

import com.richard.danis.www.sandbox.hibernate.model.BusinessEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public abstract class AbstractGenericBusinessEntityServiceImpl<T extends BusinessEntity<ID>, ID extends Serializable>
        implements GenericBusinessService<T, ID> {

    private JpaRepository<T, ID> repository;

    protected AbstractGenericBusinessEntityServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T get(@NotNull ID id) {
        return repository.getOne(id);
    }

    @Override
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<T> findAll(@NotNull Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public T save(@NotNull @Valid T t) {
        return repository.save(t);
    }

    @Override
    public void remove(@NotNull T t) {
        repository.delete(t);
    }

    @Override
    public T findById(@NotNull ID id) {
        return repository.findById(id).orElseThrow();
    }
}
