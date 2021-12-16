package com.libraryproject.librarysystem.RESTAndroidControllers;

import com.libraryproject.librarysystem.domain.Availability;
import com.libraryproject.librarysystem.domain.Books;
import com.libraryproject.librarysystem.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookRESTController {

    @Autowired
    private BooksRepository booksRepository;

    @GetMapping(value = "/rest/allBooks")
    public @ResponseBody
    Iterable<Books> getAll () {
        System.out.println(booksRepository.findAll());
        return booksRepository.findAll();
    }
}
