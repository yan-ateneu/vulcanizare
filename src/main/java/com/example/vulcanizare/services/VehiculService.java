package com.example.vulcanizare.services;

import com.example.vulcanizare.domain.Client;
import com.example.vulcanizare.domain.DetaliiClient;
import com.example.vulcanizare.domain.Vehicul;

import java.util.List;

public interface VehiculService {
    List<Vehicul> findAll();
    List<Vehicul> findByClientiId(Long l);
    Vehicul findById(Long l);
    Vehicul save(Vehicul vehicul);

    void deleteById(Long id);
}
