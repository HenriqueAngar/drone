package com.dronedelivery.apidrone.resource;

import com.dronedelivery.apidrone.model.Location;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class TrajetoDTO {

        private  Long idTrajeto;

        private Location origem;


        private Location destino;


        private Double distancia;

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
