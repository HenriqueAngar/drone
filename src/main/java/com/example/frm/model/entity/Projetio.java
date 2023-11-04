package com.example.frm.model.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "projetio")
public class Projetio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "peso")
    private Double peso;
    @NotNull
    @Column(name = "altura")
    private Double altura;
    @NotNull
    @Column(name = "largura")
    private Double largura;
    @NotNull
    @Column(name = "combustivel_peso")
    private Double combustivelPeso;
    @NotNull
    @Column(name = "combustivel_litro")
    private Double combustivelLitro;

    public Projetio() {
    }

    public Projetio(Long id, Double peso, Double altura, Double largura, Double combustivelPeso, Double combustivelLitro) {
        this.id = id;
        this.peso = peso;
        this.altura = altura;
        this.largura = largura;
        this.combustivelPeso = combustivelPeso;
        this.combustivelLitro = combustivelLitro;
    }

    public Long getId() {
        return id;
    }

    public Projetio setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getPeso() {
        return peso;
    }

    public Projetio setPeso(Double peso) {
        this.peso = peso;
        return this;
    }

    public Double getAltura() {
        return altura;
    }

    public Projetio setAltura(Double altura) {
        this.altura = altura;
        return this;
    }

    public Double getLargura() {
        return largura;
    }

    public Projetio setLargura(Double largura) {
        this.largura = largura;
        return this;
    }

    public Double getCombustivelPeso() {
        return combustivelPeso;
    }

    public Projetio setCombustivelPeso(Double combustivelPeso) {
        this.combustivelPeso = combustivelPeso;
        return this;
    }

    public Double getCombustivelLitro() {
        return combustivelLitro;
    }

    public Projetio setCombustivelLitro(Double combustivelLitro) {
        this.combustivelLitro = combustivelLitro;
        return this;
    }
}
