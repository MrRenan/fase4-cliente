package br.com.fiap.fase4cliente.features.application.usecase;

import br.com.fiap.fase4cliente.features.domain.entity.Cliente;
import br.com.fiap.fase4cliente.features.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClienteUseCase {

    @Autowired
    private ClienteService service;

    public Cliente criarCliente(Cliente cliente) {
        return service.criarCliente(cliente);
    }

    public Cliente obterClientePorId(String idCliente) {
        return service.obterClientePorId(idCliente);
    }

    public List<Cliente> obterTodosClientes() {
        return service.obterTodosClientes();
    }

    public Cliente atualizarCliente(String idCliente, Cliente cliente) {
        return service.atualizarCliente(idCliente, cliente) ;
    }

    public void deletarCliente(String idCliente) {
        service.deletarCliente(idCliente);
    }
}
