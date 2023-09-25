package com.livraria.desafio1.controller.fluxoCompraController;

import com.livraria.desafio1.controller.dto.NovaCompraResquest;
import com.livraria.desafio1.controller.validator.EstadoPertenceAPaisValidator;
import com.livraria.desafio1.controller.validator.VerificaDocumentoCpfCnpjValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class FechaCompraController {

    @Autowired
    private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(new VerificaDocumentoCpfCnpjValidator(), estadoPertenceAPaisValidator);

    }

    @PostMapping(value = "/compras")
    public String  cria (@RequestBody @Valid NovaCompraResquest resquest){
        return resquest.toString();
    }
}
