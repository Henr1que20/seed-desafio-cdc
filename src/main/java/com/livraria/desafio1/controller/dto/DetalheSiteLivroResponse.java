package com.livraria.desafio1.controller.dto;

import com.livraria.desafio1.model.Livro;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class DetalheSiteLivroResponse {
    private String titulo;
    private String resumo;
    private String sumario;
    private DatalheSiteAutorResponse autor;
    private BigDecimal preco;
    private BigInteger numeroPaginas;
    private String isbn;

    public DetalheSiteLivroResponse() {
    }

    public DetalheSiteLivroResponse(Livro livro) {
        titulo = livro.getTitulo();
        autor = new DatalheSiteAutorResponse(livro.getAutor());
        isbn = livro.getIsbn();
        numeroPaginas = livro.getNumeroPaginas();
        preco = livro.getPreco();
        resumo = livro.getResumo();
        sumario = livro.getSumario();

    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public DatalheSiteAutorResponse getAutor() {
        return autor;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public BigInteger getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }
}
