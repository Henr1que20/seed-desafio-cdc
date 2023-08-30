package com.livraria.desafio1.controller.dto;

import com.livraria.desafio1.model.Autor;

public class DatalheSiteAutorResponse {
    private String nome;
    private String email;
    private String descricao;

    public DatalheSiteAutorResponse() {
    }

    public DatalheSiteAutorResponse(Autor autor) {
        nome = autor.getNome();
        email = autor.getEmail();
        descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
