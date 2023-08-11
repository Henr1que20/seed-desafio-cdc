package com.livraria.desafio1.controller;

import com.livraria.desafio1.controller.dto.NovoLivroRequest;
import com.livraria.desafio1.model.Livro;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/create")
    @Transactional
    public String create(@RequestBody @Valid NovoLivroRequest request) {
        Livro newLivro = request.toModel(manager);
        manager.persist(newLivro);
        return newLivro.toString();
    }
}
