package com.dronedelivery.apidrone.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario", referencedColumnName = "idUsuario")
    private long usuario;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entrega", referencedColumnName = "idEntrega")
    private long entrega;

    @Column(name = "inicio")
    public LocalDateTime inicio;
    @Column(name = "fim")
    public LocalDateTime fim;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public long getUsuario() {
        return usuario;
    }

    public void setUsuario(long usuario) {
        this.usuario = usuario;
    }

    public long getEntrega() {
        return entrega;
    }

    public void setEntrega(long entrega) {
        this.entrega = entrega;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }
}
