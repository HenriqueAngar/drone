package com.dronedelivery.apidrone.resource;

import com.dronedelivery.apidrone.entreprise.NotFoundException;
import com.dronedelivery.apidrone.model.Usuario;
import com.dronedelivery.apidrone.resource.UsuarioDTO;
//import com.dronedelivery.apidrone.service.UsuarioService;
import com.dronedelivery.apidrone.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody @Validated UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.salvar(usuarioDTO.toEntity());
        UsuarioDTO savedDTO = UsuarioDTO.fromEntity(usuario);
        return ResponseEntity.created(URI.create("/api/usuarios/" + savedDTO.getIdUsuario())).body(savedDTO);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<Usuario> usuarios = usuarioService.buscarTodos();
        List<UsuarioDTO> usuarioDTOS = usuarios.stream().map(UsuarioDTO::fromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(usuarioDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable("id") Long id) {
        Usuario usuario = usuarioService.buscaPorId(id);
        UsuarioDTO usuarioDTO = UsuarioDTO.fromEntity(usuario);
        return ResponseEntity.ok(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") Long id) {
        usuarioService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable("id") Long id, @RequestBody @Validated UsuarioDTO usuarioDTO) {
        try {
            Usuario alterado = usuarioService.alterar(id, usuarioDTO.toEntity());
            UsuarioDTO alteradoDTO = UsuarioDTO.fromEntity(alterado);
            return ResponseEntity.ok(alteradoDTO);
        } catch (NotFoundException nfe) {
            return ResponseEntity.notFound().build();
        }
    }
}