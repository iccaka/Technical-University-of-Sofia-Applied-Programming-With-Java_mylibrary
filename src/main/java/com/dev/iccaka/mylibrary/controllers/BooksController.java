package com.dev.iccaka.mylibrary.controllers;

import com.dev.iccaka.mylibrary.entities.Book;
import com.dev.iccaka.mylibrary.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    BooksRepository booksRepository;

    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return booksRepository.findAll();
    }

    @GetMapping("/search/id")
    public Optional<Book> findBookById(@RequestParam Long id){
        return booksRepository.findById(id);
    }
}