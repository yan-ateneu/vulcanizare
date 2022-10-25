package com.example.vulcanizare.repositories;

import com.example.vulcanizare.domain.Client;
import com.example.vulcanizare.domain.DetaliiClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetaliiClientRepository extends JpaRepository<DetaliiClient, Long> {
}
