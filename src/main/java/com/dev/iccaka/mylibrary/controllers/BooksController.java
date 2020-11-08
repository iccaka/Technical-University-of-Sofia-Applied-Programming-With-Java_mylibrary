package com.dev.iccaka.mylibrary.controllers;

import com.dev.iccaka.mylibrary.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    BooksRepository booksRepository;

    @GetMapping("/search/id")
    public String getBookById(@RequestParam(required = false) Long id){
        String result = null;

        try{
            result = booksRepository.findById(id).toString();
        }
        catch (Exception e){
            return e.getMessage();
        }

        return result;
    }
}
