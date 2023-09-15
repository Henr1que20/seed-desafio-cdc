package com.livraria.desafio1.controller;

import com.livraria.desafio1.controller.dto.NovoEstadoRequest;
import com.livraria.desafio1.model.Estado;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/estado")
public class EstadoController {
    @PersistenceContext
    private EntityManager manager;
    @PostMapping(value = "/create")
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid NovoEstadoRequest request){
        Estado newEstado = request.toModel(manager);
        manager.persist(newEstado);
        return ResponseEntity.ok().build();
    }

}
