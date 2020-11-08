package com.dev.iccaka.mylibrary.controllers;

import com.dev.iccaka.mylibrary.entities.User;
import com.dev.iccaka.mylibrary.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/all")
    public List<User> getUsers(){
        return usersRepository.findAll();
    }

    @GetMapping("/search/id")
    public String findUserById(@RequestParam(required = false) Long id){
        String result = null;

        try{
            result = usersRepository.findById(id).toString();
        }
        catch (Exception e){
            return e.getClass().getName();
        }

        return result;
    }

    @GetMapping("/search/firstname")
    public User findUserByFirstName(@RequestParam String firstname){
        return usersRepository.findUserByFirstname(firstname);
    }
}
