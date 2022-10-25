package com.example.vulcanizare.services;

import com.example.vulcanizare.domain.Client;
import com.example.vulcanizare.domain.Vehicul;
import com.example.vulcanizare.exceptions.ResourceNotFoundException;
import com.example.vulcanizare.repositories.VehiculRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculServiceImpl implements VehiculService {
    VehiculRepository VehiculRepository;
    @Autowired
    public VehiculServiceImpl(VehiculRepository VehiculRepository) {
        this.VehiculRepository = VehiculRepository;
    }
    @Override
    public List<Vehicul> findAll() {
        List<Vehicul> vehicule = new ArrayList<>();
        VehiculRepository.findAll().iterator().forEachRemaining(vehicule::add);
        return vehicule ;
    }
    @Override
    public List<Vehicul> findByClientiId(Long l) {
        List<Vehicul> vehicule = new ArrayList<>();
        VehiculRepository.findById(l).stream().iterator().forEachRemaining(vehicule::add);

        return vehicule;
    }
    @Override
    public Vehicul findById(Long l) {
        Optional<Vehicul> vehiculOptional = VehiculRepository.findById(l);
        if (!vehiculOptional.isPresent()) {
            throw new ResourceNotFoundException("vehiculul " + l + " nu a fost gasit");
        }
        return vehiculOptional.get();
    }
    @Override
    public Vehicul save(Vehicul vehicul) {
        Vehicul saveVehicul = VehiculRepository.save(vehicul);
        return saveVehicul;
    }
    @Override
    public void deleteById(Long id) {
        Optional<Vehicul> vehiculOptional = VehiculRepository.findById(id);
        if (!vehiculOptional.isPresent()) {
            throw new RuntimeException("Vehiculul nu a fost gasit!");
        }
        Vehicul Vehicul = vehiculOptional.get();

        VehiculRepository.save(Vehicul);
        VehiculRepository.deleteById(id);

    }
}
