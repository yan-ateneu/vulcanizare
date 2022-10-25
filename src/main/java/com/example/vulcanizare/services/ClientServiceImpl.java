package com.example.vulcanizare.services;

import com.example.vulcanizare.domain.Client;
import com.example.vulcanizare.domain.Reparatie;
import com.example.vulcanizare.exceptions.ResourceNotFoundException;
import com.example.vulcanizare.repositories.ClientRepository;
import com.example.vulcanizare.repositories.ReparatieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{
    ClientRepository clientRepository;
    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @Override
    public List<Client> findAll() {
        List<Client> clienti = new ArrayList<>();
        clientRepository.findAll().iterator().forEachRemaining(clienti::add);
        return clienti ;
    }
    @Override
    public Client findById(Long l) {
        Optional<Client> clientOptional = clientRepository.findById(l);
        if (!clientOptional.isPresent()) {
            throw new ResourceNotFoundException("clientul " + l + " nu a fost gasit");
        }
        return clientOptional.get();
    }

    @Override
    public Client save(Client client) {
        Client saveClient = clientRepository.save(client);
        return saveClient;
    }
    @Override
    public void deleteById(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (!clientOptional.isPresent()) {
            throw new RuntimeException("Clientul nu a fost gasit!");
        }
        Client client = clientOptional.get();

        clientRepository.save(client);
        clientRepository.deleteById(id);

    }
}
