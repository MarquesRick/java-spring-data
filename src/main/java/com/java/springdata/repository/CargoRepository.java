package com.java.springdata.repository;

import com.java.springdata.entities.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {
    List<Cargo> findByDescricao(String descricao);
}
