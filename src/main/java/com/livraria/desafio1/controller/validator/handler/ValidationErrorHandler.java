package com.livraria.desafio1.controller.validator.handler;

import com.livraria.desafio1.service.exceptions.DuplicateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@RestControllerAdvice
public class ValidationErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgument(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Argument error");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<StandardError> methodArgument(DuplicateException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Argument error");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}