package com.dronedelivery.apidrone.resource;

import com.dronedelivery.apidrone.model.Location;
import com.dronedelivery.apidrone.model.Trajeto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class TrajetoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrajeto;

    private Location origem;

    private Location destino;

    private Double distancia;

    private Double velocidade;

    public static TrajetoDTO fromEntity(Trajeto trajeto) {
        TrajetoDTO dto = new TrajetoDTO();
        dto.setIdTrajeto(trajeto.getIdTrajeto());
        dto.setOrigem(trajeto.getOrigem());
        dto.setDestino(trajeto.getDestino());
        dto.setDistancia(trajeto.getDistancia());
        dto.setVelocidade(trajeto.getVelocidade());
        return dto;
    }

    public Trajeto toEntity() {
        Trajeto trajeto = new Trajeto();
        trajeto.setIdTrajeto(idTrajeto);
        trajeto.setOrigem(origem);
        trajeto.setDestino(destino);
        trajeto.setDistancia(distancia);
        trajeto.setVelocidade(velocidade);
        return trajeto;
    }

    public static List<TrajetoDTO> fromEntity(List<Trajeto> trajetos) {
        return trajetos.stream().map(TrajetoDTO::fromEntity).collect(Collectors.toList());
    }

    public static Page<TrajetoDTO> fromEntity(Page<Trajeto> trajetos) {
        List<TrajetoDTO> trajetosDTO = trajetos.stream().map(TrajetoDTO::fromEntity).collect(Collectors.toList());
        return new PageImpl<>(trajetosDTO, trajetos.getPageable(), trajetos.getTotalElements());
    }
}
