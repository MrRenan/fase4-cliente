package br.com.fiap.fase4cliente.features.adapter.in.v1;

import br.com.fiap.fase4cliente.features.adapter.in.v1.mapper.ClienteMapper;
import br.com.fiap.fase4cliente.features.application.usecase.ClienteUseCase;
import br.com.fiap.fase4cliente.features.domain.entity.Cliente;
import br.com.fiap.fase4cliente.features.domain.entity.Endereco;
import br.com.fiap.fase4cliente.infra.restapi.v1.model.ClienteRequest;
import br.com.fiap.fase4cliente.infra.restapi.v1.model.ClienteResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ClienteControllerTest {

    @Mock
    private ClienteUseCase useCase;

    @Mock
    private ClienteMapper mapper;

    @InjectMocks
    private ClienteController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarCliente_deveRetornarClienteResponse() {
        ClienteRequest request = new ClienteRequest("1", "João", "123456789", "CPF", "12345678901", "joao@example.com", LocalDate.now(), "M", new Endereco("Rua A", "123", "Apto 1", "Centro", "São Paulo", "SP", "12345-678"));
        ClienteResponse response = new ClienteResponse("1", "João", "123456789", "CPF", "12345678901", "joao@example.com", LocalDate.now(), "M", new Endereco("Rua A", "123", "Apto 1", "Centro", "São Paulo", "SP", "12345-678"));

        when(useCase.criarCliente(any())).thenReturn(new Cliente());
        when(mapper.paraClienteResponse(any())).thenReturn(response);

        ClienteResponse result = controller.criarCliente(request);

        assertEquals(response, result);
        verify(useCase, times(1)).criarCliente(any());
        verify(mapper, times(1)).paraClienteResponse(any());
    }

    @Test
    void obterClientePorId_deveRetornarClienteResponse() {
        ClienteResponse response = new ClienteResponse("1", "João", "123456789", "CPF", "12345678901", "joao@example.com", LocalDate.now(), "M", new Endereco("Rua A", "123", "Apto 1", "Centro", "São Paulo", "SP", "12345-678"));

        when(useCase.obterClientePorId("1")).thenReturn(new Cliente());
        when(mapper.paraClienteResponse(any())).thenReturn(response);

        ClienteResponse result = controller.obterClientePorId("1");

        assertEquals(response, result);
        verify(useCase, times(1)).obterClientePorId("1");
        verify(mapper, times(1)).paraClienteResponse(any());
    }

    @Test
    void obterTodosClientes_deveRetornarListaDeClienteResponse() {
        ClienteResponse response = new ClienteResponse("1", "João", "123456789", "CPF", "12345678901", "joao@example.com", LocalDate.now(), "M", new Endereco("Rua A", "123", "Apto 1", "Centro", "São Paulo", "SP", "12345-678"));

        when(useCase.obterTodosClientes()).thenReturn(Collections.singletonList(new Cliente()));
        when(mapper.paraClienteResponse(any())).thenReturn(response);

        List<ClienteResponse> result = controller.obterTodosClientes();

        assertEquals(1, result.size());
        verify(useCase, times(1)).obterTodosClientes();
        verify(mapper, times(1)).paraClienteResponse(any());
    }

    @Test
    void atualizarCliente_deveRetornarClienteResponse() {
        // Arrange
        Endereco endereco = new Endereco("Rua A", "123", "Apto 1", "Centro", "São Paulo", "SP", "12345-678");

        // Criação do ClienteRequest
        ClienteRequest request = new ClienteRequest("1", "João", "123456789", "CPF", "12345678901", "joao@example.com", LocalDate.now(), "M", endereco);

        // Criação do ClienteResponse esperado
        ClienteResponse response = new ClienteResponse("1", "João", "123456789", "CPF", "12345678901", "joao@example.com", LocalDate.now(), "M", endereco);

        // Criação do Cliente (entidade de domínio)
        Cliente cliente = new Cliente("1", "João", "123456789", "CPF", "12345678901", "joao@example.com", LocalDate.now(), "M", endereco);

        // Configuração dos mocks
        when(mapper.paraCliente(any(ClienteRequest.class))).thenReturn(cliente); // Mock do mapper.paraCliente
        when(useCase.atualizarCliente(eq("1"), any(Cliente.class))).thenReturn(cliente); // Mock do useCase.atualizarCliente
        when(mapper.paraClienteResponse(cliente)).thenReturn(response); // Mock do mapper.paraClienteResponse

        // Act
        ClienteResponse result = controller.atualizarCliente("1", request);

        // Assert
        assertNotNull(result, "O resultado não deve ser nulo");
        assertEquals(response, result, "O ClienteResponse retornado não corresponde ao esperado");

        // Verifica se os métodos foram chamados corretamente
        verify(mapper, times(1)).paraCliente(any(ClienteRequest.class));
        verify(useCase, times(1)).atualizarCliente(eq("1"), any(Cliente.class));
        verify(mapper, times(1)).paraClienteResponse(cliente);
    }

    @Test
    void deletarCliente_deveChamarMetodoDeletar() {
        doNothing().when(useCase).deletarCliente("1");

        controller.deletarCliente("1");

        verify(useCase, times(1)).deletarCliente("1");
    }
}