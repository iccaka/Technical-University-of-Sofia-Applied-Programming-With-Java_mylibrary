package com.dev.iccaka.mylibrary.repositories;

import com.dev.iccaka.mylibrary.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE lower(u.firstname) = :firstname")
    Optional<User> findUserByFirstname(String firstname);
}
