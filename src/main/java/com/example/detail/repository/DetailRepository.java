package com.example.detail.repository;

import com.example.detail.model.Detail;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface DetailRepository extends CrudRepository<Detail, Long> {

    @Override
    <S extends Detail> S save(S entity);

    @Override
    Optional<Detail> findById(Long aLong);

    @Override
    Iterable<Detail> findAll();

    @Override
    void delete(Detail entity);
}
