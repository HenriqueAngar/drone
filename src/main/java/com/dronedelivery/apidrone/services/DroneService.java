package com.dronedelivery.apidrone.services;

import com.dronedelivery.apidrone.entreprise.NotFoundException;
import com.dronedelivery.apidrone.model.Drone;
import com.dronedelivery.apidrone.repositories.DroneRepo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DroneService {
    @Autowired
    private DroneRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    public Drone salvar(Drone entity) {



        return repo.save(entity);
    }

    public List<Drone> buscaTodos(String filter) {
        return repo.findAll(filter, Drone.class);
    }

    public Page<Drone> buscaTodos(String filter, Pageable pageable) {
        return repo.findAll(filter, Drone.class, pageable);
    }

    public Drone buscaPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Drone alterar(Long id, Drone entity) {
        Optional<Drone> byId = repo.findById(id);
        if (byId.isEmpty()) {
            throw new NotFoundException("Drone não encontrado");
        }

        Drone existingDrone = byId.get();
        modelMapper.map(entity, existingDrone);

        return repo.save(existingDrone);
    }

    public void remover(Long id) {
        repo.deleteById(id);
    }
}
