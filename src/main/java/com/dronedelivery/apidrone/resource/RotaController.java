//New Rota Controller
package com.dronedelivery.apidrone.resource;

import com.dronedelivery.apidrone.entreprise.NotFoundException;
import com.dronedelivery.apidrone.model.Rota;
import com.dronedelivery.apidrone.services.RotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/Rotas")
public class RotaController extends AbstractController {

    @Autowired
    private RotaService service;

    @PostMapping
    public ResponseEntity<RotaDTO> create(@RequestBody @Validated RotaDTO rotaDTO) {
        Rota savedRota = service.salvar(rotaDTO.toEntity());
        RotaDTO savedRotaDTO = RotaDTO.fromEntity(savedRota);
        URI location = URI.create("/api/Rotas/" + savedRota.getIdRota());
        return ResponseEntity.created(location).body(savedRotaDTO);
    }

    @GetMapping
    public ResponseEntity<Page<RotaDTO>> findAll(@RequestParam(required = false) String filter,
                                                 @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size) {
        Page<Rota> rotas = service.buscaTodos(filter, PageRequest.of(page, size));
        Page<RotaDTO> rotaDTOS = RotaDTO.fromEntity(rotas);
        return ResponseEntity.ok(rotaDTOS);
    }

    @GetMapping("{id}")
    public ResponseEntity<RotaDTO> findById(@PathVariable("id") Long id) {
        Rota rota = service.buscaPorId(id);
        RotaDTO rotaDTO = RotaDTO.fromEntity(rota);
        return ResponseEntity.ok(rotaDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<RotaDTO> update(@PathVariable("id") Long id, @RequestBody @Validated RotaDTO rotaDTO) {
        try {
            Rota rotaAlterada = service.alterar(id, rotaDTO.toEntity());
            RotaDTO updatedRotaDTO = RotaDTO.fromEntity(rotaAlterada);
            return ResponseEntity.ok(updatedRotaDTO);
        } catch (NotFoundException nfe) {
            return ResponseEntity.noContent().build();
        }
    }
}