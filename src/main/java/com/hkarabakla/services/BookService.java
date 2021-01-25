package com.hkarabakla.services;

import com.hkarabakla.entities.Authors;
import com.hkarabakla.entities.Book;
import com.hkarabakla.repositories.BookRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.UUID;

@Component
public class BookService {

    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void bookOperations(){

        Book firstBook = new Book();
        firstBook.setIsbn(UUID.randomUUID().toString());
        firstBook.setName("book name");
        firstBook.setDescription("book is about example");
        firstBook.setImageUrl("URL");
        firstBook.setAddedDate(LocalDate.now());
        firstBook.setPublishedDate(LocalDate.now());
        firstBook.setCurrency("TRY");
        firstBook.setPrice(49.99);

        Authors firstAuthor = new Authors();
        firstAuthor.setName("Test Author");

        firstBook.setAuthors(Collections.singletonList(firstAuthor));

        bookRepo.save(firstBook);

        System.out.println("BOOKS");
        System.out.println(bookRepo.findAll());
        System.out.println("FIND BY BOOK NAME");
        System.out.println(bookRepo.findByName("book name"));



    }
}
