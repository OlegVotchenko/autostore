package com.votchenko.autostore.dao;

import com.votchenko.autostore.enums.Result;

import java.util.List;
import java.util.Optional;


public interface GlobalDAO<T> {

    List<T> findAll();

    List<T> findAll(int pageSize, int pageNumber);

    void save(T entity);

    boolean update(T entity);

    Result delete(long id);

    Optional<T> findById(long id);
}
