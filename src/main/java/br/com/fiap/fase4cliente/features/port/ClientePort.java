package br.com.fiap.fase4cliente.features.port;

import br.com.fiap.fase4cliente.features.domain.entity.Cliente;

import java.util.List;

public interface ClientePort {

    Cliente criarCliente(Cliente cliente);

    Cliente obterClientePorId(String idCliente);

    List<Cliente> obterTodosClientes();

    Cliente atualizarCliente(String idCliente, Cliente cliente);

    void deletarCliente(String idCliente);

}
