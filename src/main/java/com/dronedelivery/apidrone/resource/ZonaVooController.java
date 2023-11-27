package com.dronedelivery.apidrone.resource;
import com.dronedelivery.apidrone.entreprise.NotFoundException;
import com.dronedelivery.apidrone.model.ZonaVoo;
//import com.dronedelivery.apidrone.services.ZonaVooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/zonasvoo")
public class ZonaVooController {

    @Autowired
    private ZonaVooService zonaVooService;

    @PostMapping
    public ResponseEntity<ZonaVooDTO> create(@RequestBody @Validated ZonaVooDTO zonaVooDTO) {
        ZonaVoo zonaVoo = zonaVooService.salvar(zonaVooDTO.toEntity());
        ZonaVooDTO savedDTO = ZonaVooDTO.fromEntity(zonaVoo);
        return ResponseEntity.created(URI.create("/api/zonasvoo/" + savedDTO.getIdZonaVoo())).body(savedDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ZonaVooDTO>> findAll(@RequestParam(required = false) String filter,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size) {
        Page<ZonaVoo> zonasVoo = zonaVooService.buscaTodos(filter, PageRequest.of(page, size));
        Page<ZonaVooDTO> zonaVooDTOS = zonasVoo.map(ZonaVooDTO::fromEntity);
        return ResponseEntity.ok(zonaVooDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZonaVooDTO> findById(@PathVariable("id") Long id) {
        ZonaVoo zonaVoo = zonaVooService.buscaPorId(id);
        ZonaVooDTO zonaVooDTO = ZonaVooDTO.fromEntity(zonaVoo);
        return ResponseEntity.ok(zonaVooDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") Long id) {
        zonaVooService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ZonaVooDTO> update(@PathVariable("id") Long id, @RequestBody @Validated ZonaVooDTO zonaVooDTO) {
        try {
            ZonaVoo alterado = zonaVooService.alterar(id, zonaVooDTO.toEntity());
            ZonaVooDTO alteradoDTO = ZonaVooDTO.fromEntity(alterado);
            return ResponseEntity.ok(alteradoDTO);
        } catch (NotFoundException nfe) {
            return ResponseEntity.notFound().build();
        }
    }
}