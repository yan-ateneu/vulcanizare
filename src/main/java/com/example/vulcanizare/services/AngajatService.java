package com.example.vulcanizare.services;

import com.example.vulcanizare.domain.Angajat;
import com.example.vulcanizare.domain.Client;

import java.util.List;

public interface AngajatService {
    List<Angajat> findAll();
    Angajat findById(Long l);
    Angajat save(Angajat angajat);

    void deleteById(Long id);
}
