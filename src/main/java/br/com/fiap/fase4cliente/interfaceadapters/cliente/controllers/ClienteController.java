package br.com.fiap.fase4cliente.interfaceadapters.cliente.controllers;

import br.com.fiap.fase4cliente.application.cliente.dtos.ClienteRecordDto;
import br.com.fiap.fase4cliente.application.cliente.usecases.ClienteUseCase;
import br.com.fiap.fase4cliente.domain.cliente.entities.ClienteEntity;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ClienteController {

    final ClienteUseCase clienteUseCase;

    public ClienteController(ClienteUseCase clienteUseCase) {this.clienteUseCase = clienteUseCase;}

    @PostMapping("/clientes")
    public ResponseEntity<ClienteEntity> saveClienteEntity(@RequestBody @Valid ClienteRecordDto clienteRecordDto) {
        var clienteEntity = new ClienteEntity();
        BeanUtils.copyProperties(clienteRecordDto, clienteEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteUseCase.save(clienteEntity));
    }
}