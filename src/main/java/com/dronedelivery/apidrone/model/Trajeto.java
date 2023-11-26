package com.dronedelivery.apidrone.model;

import jakarta.persistence.*;


@Entity
@Table(name = "trajetos")
public class Trajeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idTrajeto;
    @Column(name = "origem")
    private Location origem;

    @Column(name = "destino")
    private Location destino;

    @Column(name = "distancia")
    private Double distancia;
    @Column(name = "velocidade")
    private Double velocidade;

    public Long getIdTrajeto() {
        return idTrajeto;
    }

    public void setIdTrajeto(Long idTrajeto) {
        this.idTrajeto = idTrajeto;
    }

    public Location getOrigem() {
        return origem;
    }

    public void setOrigem(Location origem) {
        this.origem = origem;
    }

    public Location getDestino() {
        return destino;
    }

    public void setDestino(Location destino) {
        this.destino = destino;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Double velocidade) {
        this.velocidade = velocidade;
    }
}

