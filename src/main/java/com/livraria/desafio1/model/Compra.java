package com.livraria.desafio1.model;

import org.springframework.util.Assert;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Compra {
    private String email;
    private String nome;
    private String sobrenome;
    private String documento;
    private String endereco;
    private String complemento;
    @ManyToOne
    private Pais pais;
    private String telefone;
    private String cep;
    @ManyToOne
    private Estado estado;

    public Compra(String email, String nome, String sobrenome, String documento, String endereco, String complemento, Pais pais, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public void setEstado(@Valid @NotNull Estado estado) {
        Assert.isTrue(estado.pertenceAPais(pais), "Este estado não e do pais associado!");
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", pais=" + pais +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", estado=" + estado +
                '}';
    }
}
