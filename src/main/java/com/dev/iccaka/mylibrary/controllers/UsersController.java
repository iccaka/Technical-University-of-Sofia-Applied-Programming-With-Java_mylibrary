package com.dev.iccaka.mylibrary.controllers;

import com.dev.iccaka.mylibrary.entities.Users;
import com.dev.iccaka.mylibrary.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/all")
    public List<Users> getUsers(){
        return usersRepository.findAll();
    }

}
