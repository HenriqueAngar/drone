package com.dronedelivery.apidrone.services;

import com.dronedelivery.apidrone.entreprise.NotFoundException;
import com.dronedelivery.apidrone.model.Usuario;
import com.dronedelivery.apidrone.repositories.UsuarioRepo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    public Usuario salvar(Usuario entity) {



        return repo.save(entity);
    }

    public List<Usuario> buscaTodos(String filter) {
        return repo.findAll(filter, Usuario.class);
    }

    public Page<Usuario> buscaTodos(String filter, Pageable pageable) {
        return repo.findAll(filter, Usuario.class, pageable);
    }

    public Usuario buscaPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Usuario alterar(Long id, Usuario entity) {
        Optional<Usuario> byId = repo.findById(id);
        if (byId.isEmpty()) {
            throw new NotFoundException("Usuario não encontrado");
        }

        Usuario existingUsuario = byId.get();
        modelMapper.map(entity, existingUsuario);

        return repo.save(existingUsuario);
    }

    public void remover(Long id) {
        repo.deleteById(id);
    }
}
