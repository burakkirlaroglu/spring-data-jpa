package com.hkarabakla.repositories;

import com.hkarabakla.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepo extends CrudRepository<Book, UUID> {

    List<Book> findAll();

    List<Book> findByName(String name);
}
