package com.livraria.desafio1.controller.dto;

import com.livraria.desafio1.controller.validator.ExistsId;
import com.livraria.desafio1.model.Livro;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PedidoItemRequest {
    @NotNull
    @ExistsId(domainClass = Livro.class, fieldName = "id")
    private Long idLivro;
    @Positive
    private int quantidade;

    public PedidoItemRequest(Long idLivro, int quantidade) {
        this.idLivro = idLivro;
        this.quantidade = quantidade;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "PedidoItemRequest{" +
                "idLivro=" + idLivro +
                ", quantidade=" + quantidade +
                '}';
    }
}
