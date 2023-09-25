package com.livraria.desafio1.controller.validator;

import com.livraria.desafio1.controller.dto.NovaCompraResquest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class VerificaDocumentoCpfCnpjValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCompraResquest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            return;
        }

        final NovaCompraResquest resquest = (NovaCompraResquest) target;
        if(!resquest.documentoValido()){
            errors.rejectValue("documento", null, "documento precisa ser cpf ou cnpj");
        }

    }
}
