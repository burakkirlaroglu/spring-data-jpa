package com.hkarabakla.repositories;

import com.hkarabakla.entities.Authors;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepo extends CrudRepository<Authors, Integer> {

    List<Authors> findAll();

    List<Authors> findByName(String name);
}
