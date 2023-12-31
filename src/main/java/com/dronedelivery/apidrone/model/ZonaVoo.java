package com.dronedelivery.apidrone.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "zonavoo")
public class ZonaVoo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idZonaVoo;

    @NotNull
    @Column(name = "raio")
    public double raio;

    @NotNull
    @Column(name = "altura")
    public double altura;

    @NotNull
    @Column(name = "tipo")
    public TipoZonaVoo zonaVoo;

    @NotNull
    @Column(name = "posicao")
    public Location posicao;

    public Long getIdZonaVoo() {
        return idZonaVoo;
    }

    public void setIdZonaVoo(Long idZonaVoo) {
        this.idZonaVoo = idZonaVoo;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public TipoZonaVoo getZonaVoo() {
        return zonaVoo;
    }

    public void setZonaVoo(TipoZonaVoo zonaVoo) {
        this.zonaVoo = zonaVoo;
    }

    public Location getPosicao() {
        return posicao;
    }

    public void setPosicao(Location posicao) {
        this.posicao = posicao;
    }
}
