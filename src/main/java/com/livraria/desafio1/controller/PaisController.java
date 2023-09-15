package com.livraria.desafio1.controller;

import com.livraria.desafio1.controller.dto.NovoPaisRequest;
import com.livraria.desafio1.model.Pais;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/pais")
public class PaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/create")
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid NovoPaisRequest request){
        Pais newPais = request.toModel();
        manager.persist(newPais);
        return ResponseEntity.ok().build();
    }

}
