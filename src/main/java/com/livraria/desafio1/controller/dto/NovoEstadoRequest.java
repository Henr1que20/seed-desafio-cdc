package com.livraria.desafio1.controller.dto;

import com.livraria.desafio1.model.Estado;
import com.livraria.desafio1.model.Pais;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoEstadoRequest {
    @NotBlank
    private String nome;
    @NotNull
    private Long paisId;

    public NovoEstadoRequest() {
    }

    public NovoEstadoRequest(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPais_id(Long paisId) {
        this.paisId = paisId;
    }

    public Estado toModel(EntityManager manager) {
        final Pais pais = manager.find(Pais.class, paisId);
        Assert.state(pais != null, "Voce esta tentando cadastrar um Estado para um Pais que nao existe id="+paisId);
        return new Estado(this.nome, pais);
    }
}
