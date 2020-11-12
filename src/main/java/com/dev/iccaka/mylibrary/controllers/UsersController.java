package com.dev.iccaka.mylibrary.controllers;

import com.dev.iccaka.mylibrary.entities.User;
import com.dev.iccaka.mylibrary.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<?> findUserById(@RequestParam(required = false) Long id){
        if(id < 0){
            return ResponseEntity.ok("Ids cannot be negative numbers.");
        }

        Optional<User> result = usersRepository.findById(id);

        return result.isPresent() ? ResponseEntity.ok(result) : ResponseEntity.ok("There's no user with such id.");
    }

    @GetMapping("/search/firstname")
    public ResponseEntity<?> findUserByFirstName(@RequestParam String firstname){
        if(firstname.isBlank() || firstname == null){
            return ResponseEntity.ok().body("You haven't entered anything to search for.");
        }

        Optional<User> result = usersRepository.findUserByFirstname(firstname.toLowerCase());

        return result.isPresent() ? ResponseEntity.ok(result) : ResponseEntity.ok("There's no user with such first name.");
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestParam(required = false) Long id,
                                     @RequestParam(required = false) String username,
                                     @RequestParam(required = false) String firstname,
                                     @RequestParam(required = false) String lastname,
                                     @RequestParam(required = false) String email,
                                     @RequestParam(required = false) String password){
        boolean isNew = id == null;

        User user = new User(id, username, firstname, lastname, email, password);
        user = usersRepository.save(user);

        Map<String, Object> response = new HashMap<>();

        response.put("generatedId", user.getId());

        if(isNew){
            response.put("message", "Successfully created.");
        }
        else {
            response.put("message", "Successfully edited.");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/id")
    public ResponseEntity<?> deleteUserById(@RequestParam Long id){
        if(!usersRepository.existsById(id)){
            return ResponseEntity.ok("There's no such user.");
        }

        usersRepository.deleteById(id);
        return ResponseEntity.ok("Deleted successfully.");
    }

    @DeleteMapping("/delete/firstname")
    public ResponseEntity<?> deleteUserByFirstName(@RequestParam String firstname){
        usersRepository.findUserByFirstname(firstname.toLowerCase()).ifPresent(user -> usersRepository.delete(user));

        return ResponseEntity.ok("Deleted successfully.");
    }
}
