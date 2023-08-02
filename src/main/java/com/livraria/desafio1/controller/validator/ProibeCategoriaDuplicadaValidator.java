package com.livraria.desafio1.controller.validator;

import com.livraria.desafio1.controller.Categoria;
import com.livraria.desafio1.controller.dto.CategoriaDTO;
import com.livraria.desafio1.repo.CategoriaRepository;
import com.livraria.desafio1.service.exceptions.DuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeCategoriaDuplicadaValidator implements Validator {
    @Autowired
    private CategoriaRepository repository;
    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CategoriaDTO dto = (CategoriaDTO) target;

        Optional<Categoria> entity = repository.findByNome(dto.getNome());

        if (entity.isPresent()) {
            throw new DuplicateException("Essa categoria ja foi cadastrado");
        }
    }
}
