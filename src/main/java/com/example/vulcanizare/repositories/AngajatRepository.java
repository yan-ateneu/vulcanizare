package com.example.vulcanizare.repositories;

import com.example.vulcanizare.domain.Angajat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AngajatRepository extends JpaRepository<Angajat, Long> {
}
