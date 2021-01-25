package com.hkarabakla.services;

import com.hkarabakla.entities.Authors;
import com.hkarabakla.entities.Book;
import com.hkarabakla.entities.Orders;
import com.hkarabakla.repositories.OrderRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.UUID;

@Component
public class OrderService {

    private final OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public void orderOperations(){

        Orders orders = new Orders();
        orders.setCreated_date(LocalDate.now());
        orders.setTotal(99.9);

        Orders orders1 = new Orders();
        orders.setCreated_date(LocalDate.now());
        orders.setTotal(21.9);

        Orders orders2 = new Orders();
        orders.setCreated_date(LocalDate.now());
        orders.setTotal(19.9);

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

        //bookList.setOrdersList(Collections.singletonList(orders));
        orders.setBookList(Collections.singletonList(bookList));

        orderRepo.save(orders);
        orderRepo.save(orders1);
        orderRepo.save(orders2);

        System.out.println("ORDERS");
        System.out.println(orderRepo.findAll());


    }
}
