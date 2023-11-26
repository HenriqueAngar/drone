package com.dronedelivery.apidrone.resource;

import com.dronedelivery.apidrone.model.Drone;
import com.dronedelivery.apidrone.model.drone;
import com.dronedelivery.apidrone.model.Location;
import com.dronedelivery.apidrone.model.StatusDrone;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class DroneDTO {

    private Long idDrone;
    private Float bateria;

    private StatusDrone status;

    private Location posicao;

    private long drone;

    public Long getIdDrone() {
        return idDrone;
    }

    public void setIdDrone(Long idDrone) {
        this.idDrone = idDrone;
    }

    public Float getBateria() {
        return bateria;
    }

    public void setBateria(Float bateria) {
        this.bateria = bateria;
    }

    public StatusDrone getStatus() {
        return status;
    }

    public void setStatus(StatusDrone status) {
        this.status = status;
    }

    public Location getPosicao() {
        return posicao;
    }

    public void setPosicao(Location posicao) {
        this.posicao = posicao;
    }

    public long getdrone() {
        return drone;
    }

    public void setdrone(long drone) {
        this.drone = drone;
    }


}
