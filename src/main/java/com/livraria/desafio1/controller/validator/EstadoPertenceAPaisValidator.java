package com.livraria.desafio1.controller.validator;

import com.livraria.desafio1.controller.dto.NovaCompraResquest;
import com.livraria.desafio1.model.Estado;
import com.livraria.desafio1.model.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EstadoPertenceAPaisValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCompraResquest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        final NovaCompraResquest resquest = (NovaCompraResquest) target;

        if(resquest.temEstado()){
            final Pais pais = manager.find(Pais.class, resquest.getIdPais());
            final Estado estado  = manager.find(Estado.class, resquest.getIdEstado());

            if (!estado.pertenceAPais(pais)){
                errors.rejectValue("idEstado", null, "Esse estado nao e do pais selecionado!!");
            }
        }
    }
}
