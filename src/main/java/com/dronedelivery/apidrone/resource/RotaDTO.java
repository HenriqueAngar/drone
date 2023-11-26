package com.dronedelivery.apidrone.resource;

import com.dronedelivery.apidrone.model.Location;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class RotaDTO {

    private Long idRota;


    private long trajeto;

    private int order;


    public LocalDateTime checked;

)
    private Location position;

    public Long getIdRota() {
        return idRota;
    }

    public void setIdRota(Long idRota) {
        this.idRota = idRota;
    }

    public long getTrajeto() {
        return trajeto;
    }

    public void setTrajeto(long trajeto) {
        this.trajeto = trajeto;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public LocalDateTime getChecked() {
        return checked;
    }

    public void setChecked(LocalDateTime checked) {
        this.checked = checked;
    }

    public Location getPosition() {
        return position;
    }

    public void setPosition(Location position) {
        this.position = position;
    }
}
