//NEW DRONE CONTROLLER
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
public class DroneController {

    @Autowired
    private DroneService service;

    @PostMapping
    public ResponseEntity<DroneDTO> create(@RequestBody @Validated Drone entity) {
        Drone savedDrone = service.salvar(entity);
        DroneDTO droneDTO = DroneDTO.fromEntity(savedDrone);
        URI location = URI.create("/api/Drones/" + savedDrone.getIdDrone());
        return ResponseEntity.created(location).body(droneDTO);
    }

    @GetMapping
    public ResponseEntity<Page<DroneDTO>> findAll(@RequestParam(required = false) String filter,
                                                  @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
        Page<Drone> drones = service.buscaTodos(filter, PageRequest.of(page, size));
        Page<DroneDTO> droneDTOS = DroneDTO.fromEntity(drones);
        return ResponseEntity.ok(droneDTOS);
    }

    @GetMapping("{id}")
    public ResponseEntity<DroneDTO> findById(@PathVariable("id") Long id) {
        Drone drone = service.buscaPorId(id);
        DroneDTO droneDTO = DroneDTO.fromEntity(drone);
        return ResponseEntity.ok(droneDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<DroneDTO> update(@PathVariable("id") Long id, @RequestBody Drone entity) {
        try {
            Drone droneAlterado = service.alterar(id, entity);
            DroneDTO droneDTO = DroneDTO.fromEntity(droneAlterado);
            return ResponseEntity.ok(droneDTO);
        } catch (NotFoundException nfe) {
            return ResponseEntity.noContent().build();
        }
    }

    @RestController
    @RequestMapping("/api/Drones")
    private static class DroneService {

        public Drone salvar(Drone entity) {
            // Implemente a lógica real de salvamento
            return null;
        }

        public void remover(Long id) {
            // Implemente a lógica real de remoção
        }

        public Page<Drone> buscaTodos(String filter, PageRequest of) {
            // Implemente a lógica real de busca paginada
            return null;
        }

        public Drone buscaPorId(Long id) {
            // Implemente a lógica real de busca por ID
            return null;
        }

        public Drone alterar(Long id, Drone entity) throws NotFoundException {
            // Implemente a lógica real de atualização
            return null;
        }
    }
}