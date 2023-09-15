package com.livraria.desafio1.controller.dto;

import com.livraria.desafio1.model.Pais;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {
    @NotBlank
    private String nome;

    public NovoPaisRequest(Pais pais) {
        this.nome = pais.getNome();
    }
    public NovoPaisRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }
}
