package com.livraria.desafio1.controller;

import com.livraria.desafio1.controller.dto.NovoLivroRequest;
import com.livraria.desafio1.model.Livro;
import com.livraria.desafio1.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @PostMapping(value = "/create")
    public String create(@RequestBody @Valid NovoLivroRequest request) {
        Livro livro = service.create(request);
        return livro.toString();
    }
}
