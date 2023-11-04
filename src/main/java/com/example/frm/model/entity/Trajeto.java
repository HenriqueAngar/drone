package com.example.frm.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "trajeto")
public class Trajeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "local_de_partida")
    private String localDePartida;
    @Column(name = "local_de_chegada")
    private String localDeChegada;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dados", referencedColumnName = "id")
    private DadosTrajeto dadosTrajeto;

    public Trajeto() {
    }

    public Trajeto(Long id, String localDePartida, String localDeChegada, DadosTrajeto dadosTrajeto) {
        Id = id;
        this.localDePartida = localDePartida;
        this.localDeChegada = localDeChegada;
        this.dadosTrajeto = dadosTrajeto;
    }

    public Long getId() {
        return Id;
    }

    public Trajeto setId(Long id) {
        Id = id;
        return this;
    }

    public String getLocalDePartida() {
        return localDePartida;
    }

    public Trajeto setLocalDePartida(String localDePartida) {
        this.localDePartida = localDePartida;
        return this;
    }

    public String getLocalDeChegada() {
        return localDeChegada;
    }

    public Trajeto setLocalDeChegada(String localDeChegada) {
        this.localDeChegada = localDeChegada;
        return this;
    }

    public DadosTrajeto getDadosTrajeto() {
        return dadosTrajeto;
    }

    public Trajeto setDadosTrajeto(DadosTrajeto dadosTrajeto) {
        this.dadosTrajeto = dadosTrajeto;
        return this;
    }
}
