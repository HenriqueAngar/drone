package com.dronedelivery.apidrone.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "rotas")
public class Rota extends Location{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRota;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trajeto", referencedColumnName = "idTrajeto")
    private long trajeto;
    @NotNull
    @Column(name = "order")
    private int order;

    @Column(name = "checked")
    public LocalDateTime checked;

    @NotNull
    @Column(name = "position")
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

