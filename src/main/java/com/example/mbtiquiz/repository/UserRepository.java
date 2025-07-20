package com.example.mbtiquiz.repository;


import com.example.mbtiquiz.model.signup.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
