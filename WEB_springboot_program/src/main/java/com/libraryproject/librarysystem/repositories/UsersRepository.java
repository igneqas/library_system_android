package com.libraryproject.librarysystem.repositories;

import com.libraryproject.librarysystem.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
