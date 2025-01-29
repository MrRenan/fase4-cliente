package br.com.fiap.fase4cliente.features.adapter.out;

import br.com.fiap.fase4cliente.features.adapter.out.mapper.ClienteMapper;
import br.com.fiap.fase4cliente.features.domain.entity.Cliente;
import br.com.fiap.fase4cliente.features.domain.exception.ClienteNaoEncontradoException;
import br.com.fiap.fase4cliente.features.port.ClientePort;
import br.com.fiap.fase4cliente.infra.mongodb.document.cliente.ClienteDocument;
import br.com.fiap.fase4cliente.infra.mongodb.repository.ClienteDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static br.com.fiap.fase4cliente.features.domain.exception.ClienteNaoEncontradoException.clienteNaoEncontradoException;
import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class ClienteAdapter implements ClientePort {

    private final ClienteDBRepository repository;

    private final ClienteMapper mapper;


    @Override
    public Cliente criarCliente(Cliente cliente) {

        var clienteDocument = mapper.paraClienteDocument(cliente);
        return mapper.paraCliente(repository.save(clienteDocument));

    }

    @Override
    public Cliente obterClientePorId(String idCliente) {
        var clienteEntity = repository.findById(idCliente)
                .orElseThrow(ClienteNaoEncontradoException::clienteNaoEncontradoException);
        return mapper.paraCliente(clienteEntity);
    }

    @Override
    public List<Cliente> obterTodosClientes() {
        return repository.findAll()
                .stream()
                .map(mapper::paraCliente)
                .collect(toList());
    }

    @Override
    public Cliente atualizarCliente(String idCliente, Cliente cliente) {
        if(repository.existsById(idCliente)) {
            ClienteDocument clienteDocument = repository.save(mapper.paraClienteDocument(cliente));
            return mapper.paraCliente(clienteDocument);
        } else throw clienteNaoEncontradoException();

    }

    @Override
    public void deletarCliente(String idCliente) {
        repository.deleteById(idCliente);
    }

}