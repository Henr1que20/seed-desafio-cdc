package com.livraria.desafio1.controller;


import com.livraria.desafio1.controller.dto.DetalheSiteLivroResponse;
import com.livraria.desafio1.model.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping(value = "/livros")
public class DetalheLivroSiteController {

    @PersistenceContext
    private EntityManager manager;


    // importante separar as classes de request e response

    @GetMapping(value = "/produtos/{id}")
    public ResponseEntity<?>  buscaDetalhada(@PathVariable("id") Long id){
        Livro livroBuscado = manager.find(Livro.class, id);

        if(livroBuscado == null){
            return ResponseEntity.notFound().build();
        }

        DetalheSiteLivroResponse response = new DetalheSiteLivroResponse(livroBuscado);

        return ResponseEntity.ok(response);
    }
}
