package br.com.fiap.fase4cliente.features.adapter.in.v1;

import br.com.fiap.fase4cliente.features.adapter.in.v1.mapper.ClienteMapper;
import br.com.fiap.fase4cliente.features.application.usecase.ClienteUseCase;
import br.com.fiap.fase4cliente.infra.restapi.v1.ClienteApi;
import br.com.fiap.fase4cliente.infra.restapi.v1.model.ClienteRequest;
import br.com.fiap.fase4cliente.infra.restapi.v1.model.ClienteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ClienteController implements ClienteApi {

    private final ClienteUseCase useCase;
    private final ClienteMapper mapper;

    @Override
    public ClienteResponse criarCliente(ClienteRequest clienteRequest) {
        var cliente = useCase.criarCliente(mapper.paraCliente(clienteRequest));
        return mapper.paraClienteResponse(cliente);
    }

    @Override
    public ClienteResponse obterClientePorId(String idCliente) {
        var cliente = useCase.obterClientePorId(idCliente);
        return mapper.paraClienteResponse(cliente);
    }

    @Override
    public List<ClienteResponse> obterTodosClientes() {
        var clienteList=  useCase.obterTodosClientes();
        return clienteList.stream().map(mapper::paraClienteResponse).collect(Collectors.toList());
    }

    @Override
    public ClienteResponse atualizarCliente(String idCliente, ClienteRequest clienteRequest) {
        var cliente = useCase.atualizarCliente(idCliente, mapper.paraCliente(clienteRequest));
        return mapper.paraClienteResponse(cliente);
    }

    @Override
    public void deletarCliente(String idCliente) {
        useCase.deletarCliente(idCliente);
    }
}
