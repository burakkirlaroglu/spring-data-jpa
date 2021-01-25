package com.hkarabakla.services;

import com.hkarabakla.entities.*;
import com.hkarabakla.repositories.UserRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


@Component
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void userOperations() {

        User u = new User();
        u.setName("TestUser");

        User u2 = new User();
        u.setName("user test");

        User u3 = new User();
        u.setName("second user test");

        Orders firstOrder = new Orders();
        firstOrder.setCreated_date(LocalDate.now());
        firstOrder.setTotal(99.9);
        firstOrder.setUser(u);

        u.setOrders(Collections.singletonList(firstOrder));


        Address address = new Address();
        address.setStreet("Gazoz sokak");
        address.setNumber("7");
        address.setCity("Istanbul");

        u.setAddress(address);

        Book bookList = new Book();
        bookList.setIsbn(UUID.randomUUID().toString());
        bookList.setName("Spring in Action");
        bookList.setAddedDate(LocalDate.now());
        bookList.setPublishedDate(LocalDate.now());
        bookList.setPrice(20.99);
        bookList.setCurrency("Euro");
        bookList.setImageUrl("URL");
        bookList.setDescription("This book is about spring framework");

        Authors fistAuthor = new Authors();
        fistAuthor.setName("Johnny deep");
        fistAuthor.setBooks(Collections.singletonList(bookList));

        bookList.setAuthors(Collections.singletonList(fistAuthor));

        //bookList.setOrdersList(Collections.singletonList(firstOrder));

        firstOrder.setBookList(Collections.singletonList(bookList));

        userRepo.save(u);
        userRepo.save(u2);
        userRepo.save(u3);

        System.out.println("USERS");
        System.out.println(userRepo.findAll());
        System.out.println("USER ORDER");
        System.out.println(userRepo.findAllByOrdersIn(u.getOrders()));
    }
}
