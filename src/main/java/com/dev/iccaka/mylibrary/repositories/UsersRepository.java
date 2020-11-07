package com.dev.iccaka.mylibrary.repositories;

import com.dev.iccaka.mylibrary.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {



}
