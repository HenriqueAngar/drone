package com.example.frm.model.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "entregas")
public class Entrega extends Location{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntrega;
    @Column(name = "nome")
    private String nome;
    @NotNull
    @Column(name = "peso")
    private Float peso;

    @NotNull
    @Column
    private StatusEntrega status;

    @NotNull
    @Column(name = "obs")
    private String obs;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trajeto", referencedColumnName = "idTrajeto")
    private long trajeto;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "rota", referencedColumnName = "idRota")
    private long rota;
}
