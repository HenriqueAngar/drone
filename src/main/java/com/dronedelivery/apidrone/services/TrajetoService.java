package com.dronedelivery.apidrone.services;

import com.dronedelivery.apidrone.entreprise.NotFoundException;
import com.dronedelivery.apidrone.model.Trajeto;
import com.dronedelivery.apidrone.repositories.TrajetoRepo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrajetoService {
    @Autowired
    private TrajetoRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    public Trajeto salvar(Trajeto entity) {



        return repo.save(entity);
    }

    public List<Trajeto> buscaTodos(String filter) {
        return repo.findAll(filter, Trajeto.class);
    }

    public Page<Trajeto> buscaTodos(String filter, Pageable pageable) {
        return repo.findAll(filter, Trajeto.class, pageable);
    }

    public Trajeto buscaPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Trajeto alterar(Long id, Trajeto entity) {
        Optional<Trajeto> byId = repo.findById(id);
        if (byId.isEmpty()) {
            throw new NotFoundException("Trajeto não encontrado");
        }

        Trajeto existingTrajeto = byId.get();
        modelMapper.map(entity, existingTrajeto);

        return repo.save(existingTrajeto);
    }

    public void remover(Long id) {
        repo.deleteById(id);
    }
}
