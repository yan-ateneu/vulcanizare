package com.example.vulcanizare.services;

import com.example.vulcanizare.domain.Reparatie;

import java.util.List;

public interface ReparatieService {
    List<Reparatie> findAll();
    Reparatie findById(Long l);
    Reparatie save(Reparatie reparatie);
    void deleteById(Long id);
}
