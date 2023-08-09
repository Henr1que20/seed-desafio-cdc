package com.livraria.desafio1.service;

import com.livraria.desafio1.controller.dto.NovoLivroRequest;
import com.livraria.desafio1.model.Autor;
import com.livraria.desafio1.model.Categoria;
import com.livraria.desafio1.model.Livro;
import com.livraria.desafio1.repo.AutorRepository;
import com.livraria.desafio1.repo.CategoriaRepository;
import com.livraria.desafio1.repo.LivroRepository;
import com.livraria.desafio1.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class LivroService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LivroRepository livroReposiory;

    @Transactional
    public Livro create(NovoLivroRequest request) {
        Livro livro = request.toModel();

        Optional<Categoria> categoria = findCatgoria(request);
        Optional<Autor> autor = findAutor(request);

        livro.setCategoria(categoria.get());
        livro.setAutor(autor.get());

        return livroReposiory.save(livro);
    }

    private Optional<Autor> findAutor(NovoLivroRequest request) {
        return Optional.ofNullable(autorRepository.findByNome(request.getAutor())
                .orElseThrow(() -> new ResourceNotFoundException("Autor not found")));
    }

    private Optional<Categoria> findCatgoria(NovoLivroRequest request) {
        return Optional.ofNullable(categoriaRepository.findByNome(request.getCategoria())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria not found")));
    }
}
