package com.livraria.desafio1.controller.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NovoPedidoRequest {

    @Positive
    @NotNull
    private BigDecimal total;
    @Size(min = 1)
    @Valid
    private List<PedidoItemRequest> itens;

    public NovoPedidoRequest(BigDecimal total, List<PedidoItemRequest> itens) {
        this.total = total;
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<PedidoItemRequest> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        return "NovoPedidoRequest{" +
                "total=" + total +
                ", itens=" + itens +
                '}';
    }
}
