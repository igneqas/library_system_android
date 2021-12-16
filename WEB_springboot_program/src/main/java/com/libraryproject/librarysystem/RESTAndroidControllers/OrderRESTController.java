package com.libraryproject.librarysystem.RESTAndroidControllers;

import com.libraryproject.librarysystem.domain.*;
import com.libraryproject.librarysystem.repositories.BooksRepository;
import com.libraryproject.librarysystem.repositories.OrdersRepository;
import com.libraryproject.librarysystem.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderRESTController {

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    UsersRepository usersRepository;

    @PostMapping(value = "/rest/createOrder")
    public @ResponseBody
    String createOrder(@RequestParam String userId, String books) {
        List<Books> booksList = new ArrayList<>();
        String temp[] = books.split(",");
        for(String id : temp) {
            Books book = booksRepository.getById(Integer.parseInt(id));
            book.setAvailability(Availability.RESERVED);
            booksRepository.save(book);
            booksList.add(booksRepository.getById(Integer.parseInt(id)));
        }
        Users user = usersRepository.getById(Integer.parseInt(userId));
        Orders order = new Orders(user, booksList, OrderStatus.UNFINISHED);
        ordersRepository.save(order);
        return "Reservation completed";
    }

    @GetMapping(value = "rest/getOrdersByUser/{id}")
    public @ResponseBody
    Iterable<Orders> getOrdersByUser(@PathVariable(name = "id") int id){
        return usersRepository.findById(id).get().getMyOrders();
    }
}
