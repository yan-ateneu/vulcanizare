package com.example.vulcanizare.repositories.security;

import com.example.vulcanizare.domain.security.Authority;
import com.example.vulcanizare.domain.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
