package br.com.fiap.fase4cliente.features.domain.service;

import br.com.fiap.fase4cliente.features.adapter.out.ClienteAdapter;
import br.com.fiap.fase4cliente.features.domain.entity.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteService {

    @Autowired
    private ClienteAdapter adapter;

    public Cliente criarCliente(Cliente cliente) {
        return adapter.criarCliente(cliente);
    }

    public Cliente obterClientePorId(String idCliente) {
        return adapter.obterClientePorId(idCliente);
    }

    public List<Cliente> obterTodosClientes() {
        return adapter.obterTodosClientes();
    }

    public Cliente atualizarCliente(String idCliente, Cliente cliente) {
        return adapter.atualizarCliente(idCliente, cliente);
    }

    public void deletarCliente(String idCliente) {
        adapter.deletarCliente(idCliente);
    }
}
