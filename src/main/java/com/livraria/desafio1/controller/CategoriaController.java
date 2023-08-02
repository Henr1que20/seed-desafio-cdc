package com.livraria.desafio1.controller;

import com.livraria.desafio1.controller.dto.CategoriaDTO;
import com.livraria.desafio1.controller.validator.ProibeCategoriaDuplicadaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {
    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private ProibeCategoriaDuplicadaValidator proibeCategoriaDuplicadaValidator;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(proibeCategoriaDuplicadaValidator);
    }

    @PostMapping(value = "/create")
    @Transactional
    public String createCategoria(@RequestBody @Valid CategoriaDTO dto) {
        Categoria categoria = dto.toModel();
        manager.persist(categoria);
        return categoria.toString();
    }
}