package com.dronedelivery.apidrone.services;

import com.dronedelivery.apidrone.entreprise.NotFoundException;
import com.dronedelivery.apidrone.model.Rota;
import com.dronedelivery.apidrone.repositories.RotaRepo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RotaService {
    @Autowired
    private RotaRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    public Rota salvar(Rota entity) {



        return repo.save(entity);
    }

    public List<Rota> buscaTodos(String filter) {
        return repo.findAll(filter, Rota.class);
    }

    public Page<Rota> buscaTodos(String filter, Pageable pageable) {
        return repo.findAll(filter, Rota.class, pageable);
    }

    public Rota buscaPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Rota alterar(Long id, Rota entity) {
        Optional<Rota> byId = repo.findById(id);
        if (byId.isEmpty()) {
            throw new NotFoundException("Rota não encontrado");
        }

        Rota existingRota = byId.get();
        modelMapper.map(entity, existingRota);

        return repo.save(existingRota);
    }

    public void remover(Long id) {
        repo.deleteById(id);
    }
}
