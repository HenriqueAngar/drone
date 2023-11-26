package com.dronedelivery.apidrone.resource;

import com.dronedelivery.apidrone.model.Location;
import com.dronedelivery.apidrone.model.TipoZonaVoo;
import jakarta.validation.constraints.NotNull;

public class ZonaVooDTO {

    private Long idZonaVoo;

    @NotNull
    private Double raio;

    @NotNull
    private Double altura;

    @NotNull
    private TipoZonaVoo zonaVoo;

    @NotNull
    private Location posicao;

    public Long getIdZonaVoo() {
        return idZonaVoo;
    }

    public void setIdZonaVoo(Long idZonaVoo) {
        this.idZonaVoo = idZonaVoo;
    }

    public Double getRaio() {
        return raio;
    }

    public void setRaio(Double raio) {
        this.raio = raio;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
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