package com.example.frm.model.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

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

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entrega", referencedColumnName = "idEntrega")
    private long entrega;
}
