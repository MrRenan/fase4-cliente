package br.com.fiap.fase4cliente.config.exception;

import br.com.fiap.fase4cliente.features.domain.exception.ClienteNaoEncontradoException;
import br.com.fiap.fase4cliente.features.domain.exception.EntregaNaoEncontradaException;
import br.com.fiap.fase4cliente.features.domain.exception.dto.SimpleError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler exceptionHandler;

    @BeforeEach
    void setUp() {
        exceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    void handleClienteNaoEncontradoException_deveRetornarResponseEntityComStatusNotFound() {
        ClienteNaoEncontradoException ex = new ClienteNaoEncontradoException("Cliente não encontrado");

        ResponseEntity<SimpleError> response = exceptionHandler.handleClienteNaoEncontradoException(ex);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Cliente não encontrado", response.getBody().getMessage());
        assertEquals("404 NOT_FOUND", response.getBody().getCode());
    }

    @Test
    void handleEntregaNaoEncontradaException_deveRetornarResponseEntityComStatusNotFound() {
        EntregaNaoEncontradaException ex = new EntregaNaoEncontradaException("Entrega não encontrada");

        ResponseEntity<SimpleError> response = exceptionHandler.handleEntregaNaoEncontradaException(ex);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Entrega não encontrada", response.getBody().getMessage());
        assertEquals("404 NOT_FOUND", response.getBody().getCode());
    }
}