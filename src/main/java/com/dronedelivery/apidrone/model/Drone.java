package com.dronedelivery.apidrone.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "drones")
public class Drone extends Location{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDrone;

    @NotNull
    @Column(name = "bateria")
    private Float bateria;

    @NotNull
    @Column(name = "status")
    private StatusDrone status;

    @NotNull
    @Column(name = "posicao")
    private Location posicao;

    @Column(name = "destino")
    private Location destino;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entrega", referencedColumnName = "idEntrega")
    private long entrega;

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

    public Location getDestino() {
        return destino;
    }

    public void setDestino(Location destino) {
        this.destino = destino;
    }

    public long getEntrega() {
        return entrega;
    }

    public void setEntrega(long entrega) {
        this.entrega = entrega;
    }

    public long getDrone() {
    }

    public void setDrone(Drone drone) {
    }
}