package com.livraria.desafio1.controller.fluxoCompraController;

import com.livraria.desafio1.controller.dto.NovaCompraResquest;
import com.livraria.desafio1.controller.validator.EstadoPertenceAPaisValidator;
import com.livraria.desafio1.controller.validator.VerificaDocumentoCpfCnpjValidator;
import com.livraria.desafio1.model.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class FechaCompraController {
    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;
    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(new VerificaDocumentoCpfCnpjValidator(), estadoPertenceAPaisValidator);

    }
    @PostMapping(value = "/compras")
    public String  cria (@RequestBody @Valid NovaCompraResquest resquest){
        Compra novaCompra = resquest.toModel(manager);
        return novaCompra.toString();
    }

    // seria bacaca cadastrar alguns dados em memoria para nao precisar
    // rodar cada endpoint toda vez

    // add logs nos metodos para entender o que esta acontecendo

    // add validação
        // se add um pais que tem estado, o estado tem que estar preenchido tbm
}
