package com.livraria.desafio1.controller.dto;

import com.livraria.desafio1.controller.validator.ExistsId;
import com.livraria.desafio1.model.Compra;
import com.livraria.desafio1.model.Estado;
import com.livraria.desafio1.model.Pais;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovaCompraResquest {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;
    @ExistsId(domainClass = Estado.class, fieldName = "id")
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;
    @Valid
    @NotNull
    private NovoPedidoRequest pedido;

    public NovaCompraResquest() {
    }

    public NovaCompraResquest(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Long idPais, Long idEstado, String telefone, String cep, NovoPedidoRequest pedido) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
        this.pedido = pedido;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public NovoPedidoRequest getPedido() {
        return pedido;
    }

    public boolean documentoValido() {
        // validação para se protejer..
        // ninguem deveria chamar o documentoValido se o dcumento ainda estiver em branco
        Assert.hasLength(documento, "voce nao deveria validar o documento se ele nao tiver sido preenchido!");

        final CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        final CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(documento, null) || cnpjValidator.isValid(documento, null);
    }

    public Compra toModel(EntityManager manager){
        @NotNull final Pais pais = manager.find(Pais.class, idPais);
        Compra compra = new Compra(email, nome, sobrenome, documento, endereco, complemento, pais, telefone, cep);
        if (idEstado != null){
            compra.setEstado(manager.find(Estado.class,idEstado));
        }

        return compra;
    }

    @Override
    public String toString() {
        return "NovaCompraResquest{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", idPais=" + idPais +
                ", idEstado=" + idEstado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", pedido=" + pedido +
                '}';
    }

    public boolean temEstado() {
        return idEstado != null;
    }
}
