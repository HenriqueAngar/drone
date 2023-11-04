package com.example.frm.model.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @NotNull
    @Column(name = "senha")
    private String senha;
    @NotNull
    @Column(name = "status")
    private String status;

    public User() {
    }

    public User(Long id, String nome, String senha, String status) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public User setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public User setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public User setStatus(String status) {
        this.status = status;
        return this;
    }
}
