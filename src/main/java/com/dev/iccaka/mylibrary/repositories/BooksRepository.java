package com.dev.iccaka.mylibrary.repositories;


import com.dev.iccaka.mylibrary.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Long> {
}
