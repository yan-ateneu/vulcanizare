package com.example.vulcanizare.services;

import com.example.vulcanizare.domain.Angajat;
import com.example.vulcanizare.domain.Vehicul;
import com.example.vulcanizare.exceptions.ResourceNotFoundException;
import com.example.vulcanizare.repositories.AngajatRepository;
import com.example.vulcanizare.repositories.VehiculRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AngajatServiceImpl implements AngajatService{
    AngajatRepository angajatRepository;
    @Autowired
    public AngajatServiceImpl(AngajatRepository angajatRepository) {
        this.angajatRepository = angajatRepository;
    }
    @Override
    public List<Angajat> findAll() {
        List<Angajat> angajati = new ArrayList<>();
        angajatRepository.findAll().iterator().forEachRemaining(angajati::add);
        return angajati ;
    }
    @Override
    public Angajat findById(Long l) {
        Optional<Angajat> angajatOptional = angajatRepository.findById(l);
        if (!angajatOptional.isPresent()) {
            throw new ResourceNotFoundException("angajatul " + l + " nu a fost gasit");
        }
        return angajatOptional.get();
    }
    @Override
    public Angajat save(Angajat angajat) {
        Angajat saveAngajat = angajatRepository.save(angajat);
        return saveAngajat;
    }
    @Override
    public void deleteById(Long id) {
        Optional<Angajat> angajatOptional = angajatRepository.findById(id);
        if (!angajatOptional.isPresent()) {
            throw new RuntimeException("Angajatul nu a fost gasit!");
        }
        Angajat angajat = angajatOptional.get();

        angajatRepository.save(angajat);
        angajatRepository.deleteById(id);

    }
}
