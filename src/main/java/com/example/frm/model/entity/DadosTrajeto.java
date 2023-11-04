package com.example.frm.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dados_trajeto")
public class DadosTrajeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "latitude_partida")
    private Double latitudePartida;
    @Column(name = "longitude_partida")
    private Double longitudePartida;
    @Column(name = "altitude_partida")
    private Double altitudePartida;
    @Column(name = "latitude_chegada")
    private Double latitudeChegada;
    @Column(name = "longitude_chegada")
    private Double longitudeChegada;
    @Column(name = "altitude_chegada")
    private Double altitudeChegada;
    @Column(name = "distancia")
    private Double distancia;
    @Column(name = "velocidade")
    private Double velocidade;

    public DadosTrajeto() {
    }

    public DadosTrajeto(Long id, Double latitudePartida, Double longitudePartida, Double altitudePartida, Double latitudeChegada, Double longitudeChegada, Double altitudeChegada, Double distancia, Double velocidade) {
        this.id = id;
        this.latitudePartida = latitudePartida;
        this.longitudePartida = longitudePartida;
        this.altitudePartida = altitudePartida;
        this.latitudeChegada = latitudeChegada;
        this.longitudeChegada = longitudeChegada;
        this.altitudeChegada = altitudeChegada;
        this.distancia = distancia;
        this.velocidade = velocidade;
    }

    public Long getId() {
        return id;
    }

    public DadosTrajeto setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getLatitudePartida() {
        return latitudePartida;
    }

    public DadosTrajeto setLatitudePartida(Double latitudePartida) {
        this.latitudePartida = latitudePartida;
        return this;
    }

    public Double getLongitudePartida() {
        return longitudePartida;
    }

    public DadosTrajeto setLongitudePartida(Double longitudePartida) {
        this.longitudePartida = longitudePartida;
        return this;
    }

    public Double getAltitudePartida() {
        return altitudePartida;
    }

    public DadosTrajeto setAltitudePartida(Double altitudePartida) {
        this.altitudePartida = altitudePartida;
        return this;
    }

    public Double getLatitudeChegada() {
        return latitudeChegada;
    }

    public DadosTrajeto setLatitudeChegada(Double latitudeChegada) {
        this.latitudeChegada = latitudeChegada;
        return this;
    }

    public Double getLongitudeChegada() {
        return longitudeChegada;
    }

    public DadosTrajeto setLongitudeChegada(Double longitudeChegada) {
        this.longitudeChegada = longitudeChegada;
        return this;
    }

    public Double getAltitudeChegada() {
        return altitudeChegada;
    }

    public DadosTrajeto setAltitudeChegada(Double altitudeChegada) {
        this.altitudeChegada = altitudeChegada;
        return this;
    }

    public Double getDistancia() {
        return distancia;
    }

    public DadosTrajeto setDistancia(Double distancia) {
        this.distancia = distancia;
        return this;
    }

    public Double getVelocidade() {
        return velocidade;
    }

    public DadosTrajeto setVelocidade(Double velocidade) {
        this.velocidade = velocidade;
        return this;
    }
}
