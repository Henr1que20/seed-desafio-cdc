package com.livraria.desafio1.controller;

import com.livraria.desafio1.controller.dto.AutorDTO;
import com.livraria.desafio1.model.Autor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/autor")
public class AutorController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/create")
    @Transactional
    public String createAutor(@RequestBody @Valid AutorDTO dto){
        final Autor autor = dto.toModel();
        manager.persist(autor);
        return autor.toString();
    }
}
