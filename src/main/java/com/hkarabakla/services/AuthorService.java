package com.hkarabakla.services;

import com.hkarabakla.entities.Authors;
import com.hkarabakla.repositories.AuthorRepo;
import org.springframework.stereotype.Component;

@Component
public class AuthorService {

    private final AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public void authorOperations(){

        Authors fAuthor = new Authors();
        fAuthor.setName("author 1");

        Authors sAuthor = new Authors();
        sAuthor.setName("author 2");

        authorRepo.save(fAuthor);

        authorRepo.save(sAuthor);

        System.out.println("AUTHORS");
        System.out.println(authorRepo.findAll());
        System.out.println("FIND BY AUTHOR NAME");
        System.out.println(authorRepo.findByName("author 1"));

    }
}
