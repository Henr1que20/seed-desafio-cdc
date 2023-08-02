package com.livraria.desafio1.controller;

import com.livraria.desafio1.controller.dto.AutorDTO;
import com.livraria.desafio1.controller.validator.ProibeEmailDuplicadoAutorValidator;
import com.livraria.desafio1.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/autor")
public class AutorController {
    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(proibeEmailDuplicadoAutorValidator);
    }

    @PostMapping("/create")
    @Transactional
    public String createAutor(@RequestBody @Valid AutorDTO dto){
        final Autor autor = dto.toModel();
        manager.persist(autor);
        return autor.toString();
    }
}
