//New Trajeto Controller
package com.dronedelivery.apidrone.resource;

import com.dronedelivery.apidrone.entreprise.NotFoundException;
import com.dronedelivery.apidrone.model.Trajeto;
import com.dronedelivery.apidrone.service.TrajetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/Trajetos")
public class TrajetoController {

    @Autowired
    private TrajetoService trajetoService;

    @PostMapping
    public ResponseEntity<TrajetoDTO> create(@RequestBody @Validated TrajetoDTO trajetoDTO) {
        Trajeto trajeto = trajetoService.salvar(trajetoDTO.toEntity());
        TrajetoDTO savedDTO = TrajetoDTO.fromEntity(trajeto);
        URI location = URI.create("/api/Trajetos/" + savedDTO.getIdTrajeto());
        return ResponseEntity.created(location).body(savedDTO);
    }

    @GetMapping
    public ResponseEntity<Page<TrajetoDTO>> findAll(@RequestParam(required = false) String filter,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size) {
        Page<Trajeto> trajetos = trajetoService.buscaTodos(filter, PageRequest.of(page, size));
        Page<TrajetoDTO> trajetoDTOS = TrajetoDTO.fromEntity(trajetos);
        return ResponseEntity.ok(trajetoDTOS);
    }

    @GetMapping("{id}")
    public ResponseEntity<TrajetoDTO> findById(@PathVariable("id") Long id) {
        Trajeto trajeto = trajetoService.buscaPorId(id);
        TrajetoDTO trajetoDTO = TrajetoDTO.fromEntity(trajeto);
        return ResponseEntity.ok(trajetoDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") Long id) {
        trajetoService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<TrajetoDTO> update(@PathVariable("id") Long id, @RequestBody @Validated TrajetoDTO trajetoDTO) {
        try {
            Trajeto trajetoAlterado = trajetoService.alterar(id, trajetoDTO.toEntity());
            TrajetoDTO alteradoDTO = TrajetoDTO.fromEntity(trajetoAlterado);
            return ResponseEntity.ok(alteradoDTO);
        } catch (NotFoundException nfe) {
            return ResponseEntity.notFound().build();
        }
    }
}