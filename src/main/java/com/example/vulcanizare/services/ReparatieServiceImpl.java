package com.example.vulcanizare.services;

import com.example.vulcanizare.domain.Reparatie;
import com.example.vulcanizare.domain.Vehicul;
import com.example.vulcanizare.exceptions.ResourceNotFoundException;
import com.example.vulcanizare.repositories.ReparatieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ReparatieServiceImpl implements ReparatieService{
     ReparatieRepository reparatieRepository;
    @Autowired
    public ReparatieServiceImpl(ReparatieRepository reparatieRepository) {
        this.reparatieRepository = reparatieRepository;
    }
    @Override
    public List<Reparatie> findAll() {
        List<Reparatie> reparatii = new ArrayList<>();
        reparatieRepository.findAll().iterator().forEachRemaining(reparatii::add);
        return reparatii ;
    }
    @Override
    public Reparatie findById(Long l) {
        Optional<Reparatie> reparatieOptional = reparatieRepository.findById(l);
        if (!reparatieOptional.isPresent()) {
            throw new ResourceNotFoundException("reparatie " + l + " nu a fost gasita");
        }
        return reparatieOptional.get();
    }

    @Override
    public Reparatie save(Reparatie reparatie) {
        Reparatie saveReparatie = reparatieRepository.save(reparatie);
        return saveReparatie;
    }
    @Override
    public void deleteById(Long id) {
        Optional<Reparatie> reparatieOptional = reparatieRepository.findById(id);
        if (!reparatieOptional.isPresent()) {
            throw new RuntimeException("Reparatia nu a fost gasita!");
        }
        Reparatie reparatie = reparatieOptional.get();

        reparatieRepository.save(reparatie);
        reparatieRepository.deleteById(id);

    }
}
