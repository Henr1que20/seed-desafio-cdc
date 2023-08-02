package com.livraria.desafio1.controller.dto;

import com.livraria.desafio1.controller.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {
    @NotBlank
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }
}
