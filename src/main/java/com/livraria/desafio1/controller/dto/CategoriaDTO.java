package com.livraria.desafio1.controller.dto;

import com.livraria.desafio1.model.Categoria;
import com.livraria.desafio1.controller.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {
    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
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
