package com.example.vulcanizare.services;

import com.example.vulcanizare.domain.Client;
import com.example.vulcanizare.domain.Reparatie;

import java.util.List;

public interface ClientService {
    List<Client> findAll();
    Client findById(Long l);
    Client save(Client client);

    void deleteById(Long id);
}
