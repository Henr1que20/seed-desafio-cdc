package com.livraria.desafio1.controller.validator;

import com.livraria.desafio1.controller.dto.AutorDTO;
import com.livraria.desafio1.model.Autor;
import com.livraria.desafio1.repo.AutorRepository;
import com.livraria.desafio1.service.exceptions.DuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {
    @Autowired
    private AutorRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AutorDTO autor = (AutorDTO) target;

        Optional<Autor> entity = repository.findByEmail(autor.getEmail());

        if (entity.isPresent()) {
            throw new DuplicateException("Esse email ja foi cadastrado");
        }
    }
}
