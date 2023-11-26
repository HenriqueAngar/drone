package com.dronedelivery.apidrone.resource;

import com.dronedelivery.apidrone.model.Location;
import com.dronedelivery.apidrone.model.Rota;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RotaDTO {

    private Long idRota;
    private long trajeto;
    private int order;
    private LocalDateTime checked;
    private Location position;

    public static RotaDTO fromEntity(Rota rota) {
        RotaDTO dto = new RotaDTO();
        dto.setIdRota(rota.getIdRota());
        dto.setTrajeto(rota.getTrajeto());
        dto.setOrder(rota.getOrder());
        dto.setChecked(rota.getChecked());
        dto.setPosition(rota.getPosition());
        return dto;
    }

    public Rota toEntity() {
        Rota rota = new Rota();
        rota.setIdRota(idRota);
        rota.setTrajeto(trajeto);
        rota.setOrder(order);
        rota.setChecked(checked);
        rota.setPosition(position);
        return rota;
    }

    public static List<RotaDTO> fromEntity(List<Rota> rotas) {
        return rotas.stream().map(RotaDTO::fromEntity).collect(Collectors.toList());
    }

    public static Page<RotaDTO> fromEntity(Page<Rota> rotas) {
        List<RotaDTO> rotasDTO = rotas.stream().map(RotaDTO::fromEntity).collect(Collectors.toList());
        return new PageImpl<>(rotasDTO, rotas.getPageable(), rotas.getTotalElements());
    }
}
