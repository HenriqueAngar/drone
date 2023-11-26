package com.dronedelivery.apidrone.services;

import com.dronedelivery.apidrone.entreprise.NotFoundException;
import com.dronedelivery.apidrone.model.Pedido;
import com.dronedelivery.apidrone.model.Pedido;
import com.dronedelivery.apidrone.repositories.PedidoRepo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    public Pedido salvar(Pedido entity) {



        return repo.save(entity);
    }

    public List<Pedido> buscaTodos(String filter) {
        return repo.findAll(filter, Pedido.class);
    }

    public Page<Pedido> buscaTodos(String filter, Pageable pageable) {
        return repo.findAll(filter, Pedido.class, pageable);
    }

    public Pedido buscaPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Pedido alterar(Long id, Pedido entity) {
        Optional<Pedido> byId = repo.findById(id);
        if (byId.isEmpty()) {
            throw new NotFoundException("Pedido não encontrado");
        }

        Pedido existingPedido = byId.get();
        modelMapper.map(entity, existingPedido);

        return repo.save(existingPedido);
    }

    public void remover(Long id) {
        repo.deleteById(id);
    }
}
