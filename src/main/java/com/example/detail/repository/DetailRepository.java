package com.example.detail.repository;

import com.example.detail.model.Detail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
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

    @Override
    void deleteById(Long aLong);

    @Query(value = "SELECT * FROM detail WHERE YEAR (prod) > :year", nativeQuery = true)
    List<Detail> getDetailsByProd(@Param("year") int year);
}
