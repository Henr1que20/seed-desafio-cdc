package com.livraria.desafio1.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.livraria.desafio1.controller.validator.ExistsId;
import com.livraria.desafio1.controller.validator.UniqueValue;
import com.livraria.desafio1.model.Autor;
import com.livraria.desafio1.model.Categoria;
import com.livraria.desafio1.model.Livro;
import com.sun.istack.NotNull;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class NovoLivroRequest {
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=3, fraction=2)
    private BigDecimal preco;
    @DecimalMin(value = "100", inclusive = false)
    private BigInteger numeroPaginas;
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;
    @NotNull
    @ExistsId(domainClass =  Categoria.class, fieldName = "id")
    private Long idCategoria;
    @NotNull
    @ExistsId(domainClass =  Autor.class, fieldName = "id")
    private Long idAutor;

    public NovoLivroRequest() {
    }

    public NovoLivroRequest(String titulo, String resumo, String sumario, BigDecimal preco, BigInteger numeroPaginas, String isbn, LocalDate dataPublicacao, Long idCategoria, Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigInteger getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(BigInteger numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

//    public Livro toModel() {
//        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas, this.isbn,
//                this.dataPublicacao);
//    }

    public Livro toModel(final EntityManager manager) {
        final Autor autor = manager.find(Autor.class, idAutor);
        final Categoria categoria = manager.find(Categoria.class, idCategoria);

        Assert.state(autor != null, "Voce esta tentando cadastrar um Livro para um autor que nao existe id="+idAutor);
        Assert.state(categoria != null, "Voce esta tentando cadastrar um Livro para uma categoria que nao existe id="+idCategoria);

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas, this.isbn,
                this.dataPublicacao, categoria, autor);
    }
}
