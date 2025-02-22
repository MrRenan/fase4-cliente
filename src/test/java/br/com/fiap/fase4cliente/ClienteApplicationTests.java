package br.com.fiap.fase4cliente;

import br.com.fiap.fase4cliente.features.adapter.in.v1.ClienteController;
import br.com.fiap.fase4cliente.features.adapter.in.v1.mapper.ClienteMapper;
import br.com.fiap.fase4cliente.features.domain.entity.Cliente;
import br.com.fiap.fase4cliente.features.domain.entity.Endereco;
import br.com.fiap.fase4cliente.features.domain.service.ClienteService;
import br.com.fiap.fase4cliente.infra.restapi.v1.model.ClienteRequest;
import br.com.fiap.fase4cliente.infra.restapi.v1.model.ClienteResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClienteApplicationTests {

    @Autowired
    private ClienteController controller;

    @Autowired
    private ClienteMapper mapper;

    @MockBean
    private ClienteService service;

    @Test
    void contextLoads() {
    }

    @Test
    void criarCliente_deveRetornarClienteResponse() {
        ClienteRequest request = new ClienteRequest("1", "João", "123456789", "CPF", "12345678901", "joao@example.com", LocalDate.now(), "M", new Endereco("Rua A", "123", "Apto 1", "Centro", "São Paulo", "SP", "12345-678"));
        ClienteResponse response = new ClienteResponse("1", "João", "123456789", "CPF", "12345678901", "joao@example.com", LocalDate.now(), "M", new Endereco("Rua A", "123", "Apto 1", "Centro", "São Paulo", "SP", "12345-678"));

        when(service.criarCliente(any())).thenReturn(mapper.paraCliente(request));

        ClienteResponse result = controller.criarCliente(request);

        assertEquals(response, result);
    }

    @Test
    void obterTodosClientes_deveRetornarListaDeClienteResponse() {
        ClienteResponse response = new ClienteResponse("1", "João", "123456789", "CPF", "12345678901", "joao@example.com", LocalDate.now(), "M", new Endereco("Rua A", "123", "Apto 1", "Centro", "São Paulo", "SP", "12345-678"));

        when(service.obterTodosClientes()).thenReturn(Collections.singletonList(new Cliente()));

        List<ClienteResponse> result = controller.obterTodosClientes();

        assertEquals(1, result.size());
    }
}