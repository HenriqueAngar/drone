package com.example.frm.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "plano_de_voo")
public class PlanoDeVoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "trajeto_id")
    private Trajeto trajeto;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "projetio_id")
    private Projetio projetio;
    @Column(name = "data_lancamento")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dataLancamento;

    public PlanoDeVoo() {
    }

    public PlanoDeVoo(Long id, User user, Trajeto trajeto, Projetio projetio, Date dataLancamento) {
        this.id = id;
        this.user = user;
        this.trajeto = trajeto;
        this.projetio = projetio;
        this.dataLancamento = dataLancamento;
    }

    public Long getId() {
        return id;
    }

    public PlanoDeVoo setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public PlanoDeVoo setUser(User user) {
        this.user = user;
        return this;
    }

    public Trajeto getTrajeto() {
        return trajeto;
    }

    public PlanoDeVoo setTrajeto(Trajeto trajeto) {
        this.trajeto = trajeto;
        return this;
    }

    public Projetio getProjetio() {
        return projetio;
    }

    public PlanoDeVoo setProjetio(Projetio projetio) {
        this.projetio = projetio;
        return this;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public PlanoDeVoo setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
        return this;
    }
}
