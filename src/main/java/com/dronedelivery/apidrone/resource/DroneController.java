package com.dronedelivery.apidrone.resource;

import com.dronedelivery.apidrone.entreprise.NotFoundException;
import com.dronedelivery.apidrone.model.Drone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/Drones")
public class DroneController extends AbstractController {

    @Autowired
    private DroneService service;

    @PostMapping
    public ResponseEntity create(@RequestBody @Validated Drone entity) {
        Drone save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/Drones/" + entity.getIdDrone())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false) String filter,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
        Page<Drone> Drones = service.buscaTodos(filter, PageRequest.of(page, size));
        Page<DroneDTO> DroneDTOS = DroneDTO.fromEntity(Drones);
        return ResponseEntity.ok(DroneDTOS);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Drone Drone = service.buscaPorId(id);
        return ResponseEntity.ok(Drone);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Drone entity) {
        try {
            Drone alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        } catch (NotFoundException nfe) {
            return ResponseEntity.noContent().build();
        }
    }

    private class DroneService {
        public Drone salvar(Drone entity) {
            return null;
        }

        public void remover(Long id) {

        }

        public Page<Drone> buscaTodos(String filter, PageRequest of) {
            return null;
        }
    }
}