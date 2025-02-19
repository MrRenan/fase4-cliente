package br.com.fiap.fase4cliente.config.exception;


import br.com.fiap.fase4cliente.features.domain.exception.ClienteNaoEncontradoException;
import br.com.fiap.fase4cliente.features.domain.exception.EntregaNaoEncontradaException;
import br.com.fiap.fase4cliente.features.domain.exception.dto.SimpleError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<SimpleError> handleClienteNaoEncontradoException(ClienteNaoEncontradoException ex) {
        return ResponseEntity.status(NOT_FOUND).body(new SimpleError(ex.getMessage(), NOT_FOUND.toString()));
    }

    @ExceptionHandler(EntregaNaoEncontradaException.class)
    public ResponseEntity<SimpleError> handleEntregaNaoEncontradaException(EntregaNaoEncontradaException ex) {
        return ResponseEntity.status(NOT_FOUND).body(new SimpleError(ex.getMessage(), NOT_FOUND.toString()));
    }

}
