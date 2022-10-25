package com.example.vulcanizare.repositories.security;

import com.example.vulcanizare.domain.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
