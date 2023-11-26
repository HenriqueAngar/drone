package com.dronedelivery.apidrone.resource;

import com.dronedelivery.apidrone.model.Location;
import com.dronedelivery.apidrone.model.TipoZonaVoo;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public class ZonaVooDTO {

    private Long idZonaVoo;


    public double raio;


    public double altura;


    public TipoZonaVoo zonaVoo;


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
