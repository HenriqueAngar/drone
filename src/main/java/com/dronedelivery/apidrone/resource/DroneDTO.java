package com.dronedelivery.apidrone.resource;

import com.dronedelivery.apidrone.model.Drone;
import com.dronedelivery.apidrone.model.Location;
import com.dronedelivery.apidrone.model.StatusDrone;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class DroneDTO {

    private Long idDrone;
    private Float bateria;
    private StatusDrone status;
    private Location posicao;
    private long drone;

    public static DroneDTO fromEntity(Drone drone) {
        DroneDTO dto = new DroneDTO();
        dto.setIdDrone(drone.getIdDrone());
        dto.setBateria(drone.getBateria());
        dto.setStatus(drone.getStatus());
        dto.setPosicao(drone.getPosicao());
        dto.setDrone(drone.getDrone());
        return dto;
    }

    public Drone toEntity() {
        Drone drone = new Drone();
        drone.setIdDrone(idDrone);
        drone.setBateria(bateria);
        drone.setStatus(status);
        drone.setPosicao(posicao);
        drone.setDrone(drone);
        return drone;
    }

    public static List<DroneDTO> fromEntity(List<Drone> drones) {
        return drones.stream().map(DroneDTO::fromEntity).collect(Collectors.toList());
    }

    public static Page<DroneDTO> fromEntity(Page<Drone> drones) {
        List<DroneDTO> dronesDTO = drones.stream().map(DroneDTO::fromEntity).collect(Collectors.toList());
        return new PageImpl<>(dronesDTO, drones.getPageable(), drones.getTotalElements());
    }
}
