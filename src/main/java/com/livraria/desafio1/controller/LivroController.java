package com.livraria.desafio1.controller;

import com.livraria.desafio1.controller.dto.NovoLivroRequest;
import com.livraria.desafio1.model.Livro;
import com.livraria.desafio1.repo.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private LivroRepository repository;

    @PostMapping(value = "/create")
    @Transactional
    public String create(@RequestBody @Valid NovoLivroRequest request) {
        Livro newLivro = request.toModel(manager);
        manager.persist(newLivro);
        return newLivro.toString();
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Livro>> findAll(){
        List<Livro> list = repository.findAll();
        return ResponseEntity.ok(list);
    }
}
