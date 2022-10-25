package com.example.vulcanizare.repositories;

import com.example.vulcanizare.domain.Reparatie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReparatieRepository extends JpaRepository<Reparatie, Long> {
}
