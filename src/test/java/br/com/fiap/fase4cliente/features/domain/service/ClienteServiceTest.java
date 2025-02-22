package br.com.fiap.fase4cliente.features.domain.service;

import br.com.fiap.fase4cliente.features.adapter.out.ClienteAdapter;
import br.com.fiap.fase4cliente.features.domain.entity.Cliente;
import br.com.fiap.fase4cliente.features.domain.exception.ClienteNaoEncontradoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @Mock
    private ClienteAdapter adapter;

    @InjectMocks
    private ClienteService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarCliente_deveRetornarCliente() {
        Cliente cliente = new Cliente();
        when(adapter.criarCliente(any())).thenReturn(cliente);

        Cliente result = service.criarCliente(cliente);

        assertEquals(cliente, result);
        verify(adapter, times(1)).criarCliente(any());
    }

    @Test
    void obterClientePorId_deveRetornarCliente() {
        Cliente cliente = new Cliente();
        when(adapter.obterClientePorId("1")).thenReturn(cliente);

        Cliente result = service.obterClientePorId("1");

        assertEquals(cliente, result);
        verify(adapter, times(1)).obterClientePorId("1");
    }

    @Test
    void obterClientePorId_deveLancarExcecaoQuandoClienteNaoEncontrado() {
        when(adapter.obterClientePorId("1")).thenThrow(new ClienteNaoEncontradoException("Cliente não encontrado"));

        assertThrows(ClienteNaoEncontradoException.class, () -> service.obterClientePorId("1"));
        verify(adapter, times(1)).obterClientePorId("1");
    }

    @Test
    void obterTodosClientes_deveRetornarListaDeClientes() {
        Cliente cliente = new Cliente();
        when(adapter.obterTodosClientes()).thenReturn(Collections.singletonList(cliente));

        List<Cliente> result = service.obterTodosClientes();

        assertEquals(1, result.size());
        verify(adapter, times(1)).obterTodosClientes();
    }

    @Test
    void atualizarCliente_deveRetornarClienteAtualizado() {
        Cliente cliente = new Cliente();
        when(adapter.atualizarCliente("1", cliente)).thenReturn(cliente);

        Cliente result = service.atualizarCliente("1", cliente);

        assertEquals(cliente, result);
        verify(adapter, times(1)).atualizarCliente("1", cliente);
    }

    @Test
    void deletarCliente_deveChamarMetodoDeletar() {
        doNothing().when(adapter).deletarCliente("1");

        service.deletarCliente("1");

        verify(adapter, times(1)).deletarCliente("1");
    }
}