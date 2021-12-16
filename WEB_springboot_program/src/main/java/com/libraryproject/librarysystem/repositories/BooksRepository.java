package com.libraryproject.librarysystem.repositories;

import com.libraryproject.librarysystem.domain.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BooksRepository extends JpaRepository<Books, Integer> {

}
