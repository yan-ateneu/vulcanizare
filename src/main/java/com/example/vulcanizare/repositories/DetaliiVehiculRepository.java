package com.example.vulcanizare.repositories;

import com.example.vulcanizare.domain.Client;
import com.example.vulcanizare.domain.DetaliiVehicul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetaliiVehiculRepository extends JpaRepository<DetaliiVehicul, Long> {
}
