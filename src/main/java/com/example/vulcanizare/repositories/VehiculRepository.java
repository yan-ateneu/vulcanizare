package com.example.vulcanizare.repositories;

import com.example.vulcanizare.domain.Vehicul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculRepository extends JpaRepository<Vehicul, Long> {
}
