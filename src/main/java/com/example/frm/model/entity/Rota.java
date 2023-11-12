package com.example.frm.model.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rotas")
public class Rota extends Location{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRota;


    @NotNull
    @Column(name = "order")
    private int order;

    @NotNull
    @Column(name = "position")
    private Location position;

    @NotNull
    @Column(name = "checked")
    private boolean checked;


}
