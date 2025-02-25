package com.codes_tech.delivery_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codes_tech.delivery_manager.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}
