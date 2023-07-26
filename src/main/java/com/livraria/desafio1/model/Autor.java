package com.livraria.desafio1.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tb_autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private String email;
    private String descricao;
    private Instant datCriacao;
    public Autor() {
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor(Long id, String nome, String email, String descricao) {
        Id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    @PrePersist
    private void prePersist(){
        if(datCriacao == null){
            datCriacao = Instant.now();
        }
    }

    @Override
    public String toString() {
        return "Autor{" +
                "Id=" + Id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                ", datCriacao=" + datCriacao +
                '}';
    }
}
