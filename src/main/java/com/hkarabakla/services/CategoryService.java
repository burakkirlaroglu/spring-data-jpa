package com.hkarabakla.services;

import com.hkarabakla.entities.Authors;
import com.hkarabakla.entities.Book;
import com.hkarabakla.entities.Category;
import com.hkarabakla.entities.Orders;
import com.hkarabakla.repositories.CategoryRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public void categoryOperations() {

        Book myBook = new Book();

        myBook.setIsbn(UUID.randomUUID().toString());
        myBook.setName("Spring in Action");
        myBook.setAddedDate(LocalDate.now());
        myBook.setPublishedDate(LocalDate.now());
        myBook.setPrice(20.99);
        myBook.setCurrency("Euro");
        myBook.setImageUrl("URL");
        myBook.setDescription("This book is about spring framework");

        Authors fistAuthor = new Authors();
        fistAuthor.setName("Johnny deep");
        fistAuthor.setBooks(Collections.singletonList(myBook));

        myBook.setAuthors(Collections.singletonList(fistAuthor));

        Category c1 = new Category();
        c1.setName("Computer Science");
        c1.setBooks(Collections.singletonList(myBook));

        categoryRepo.save(c1);
        System.out.println("CATEGORIES");
        System.out.println(categoryRepo.findAll());
    }
}
