package br.com.fiap.fase4cliente.features.adapter.out;

import br.com.fiap.fase4cliente.features.adapter.out.mapper.ClienteMapper;
import br.com.fiap.fase4cliente.features.domain.entity.Cliente;
import br.com.fiap.fase4cliente.features.domain.entity.Endereco;
import br.com.fiap.fase4cliente.features.domain.exception.ClienteNaoEncontradoException;
import br.com.fiap.fase4cliente.infra.mongodb.document.cliente.ClienteDocument;
import br.com.fiap.fase4cliente.infra.mongodb.repository.ClienteDBRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ClienteAdapterTest {

    @Mock
    private ClienteDBRepository repository;

    @Mock
    private ClienteMapper mapper;

    @InjectMocks
    private ClienteAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarCliente_deveRetornarCliente() {
        // Arrange
        Endereco endereco = new Endereco("Rua A", "123", "Apto 1", "Centro", "São Paulo", "SP", "12345-678");
        Cliente cliente = new Cliente("1", "João", "123456789", "CPF", "12345678901", "joao@example.com", LocalDate.now(), "M", endereco);
        ClienteDocument clienteDocument = new ClienteDocument("1", "João", "123456789", "CPF", "12345678901", "joao@example.com", LocalDate.now(), "M", endereco);

        when(mapper.paraClienteDocument(cliente)).thenReturn(clienteDocument);
        when(repository.save(clienteDocument)).thenReturn(clienteDocument);
        when(mapper.paraCliente(clienteDocument)).thenReturn(cliente);

        // Act
        Cliente result = adapter.criarCliente(cliente);

        // Assert
        assertEquals(cliente, result);
        verify(mapper, times(1)).paraClienteDocument(cliente);
        verify(repository, times(1)).save(clienteDocument);
        verify(mapper, times(1)).paraCliente(clienteDocument);
    }

    @Test
    void obterClientePorId_deveRetornarCliente() {
        // Arrange
        Endereco endereco = new Endereco("Rua A", "123", "Apto 1", "Centro", "São Paulo", "SP", "12345-678");
        Cliente cliente = new Cliente("1", "João", "123456789", "CPF", "12345678901", "joao@example.com", LocalDate.now(), "M", endereco);
        ClienteDocument clienteDocument = new ClienteDocument("1", "João", "123456789", "CPF", "12345678901", "joao@example.com", LocalDate.now(), "M", endereco);

        when(repository.findById("1")).thenReturn(Optional.of(clienteDocument));
        when(mapper.paraCliente(clienteDocument)).thenReturn(cliente);

        // Act
        Cliente result = adapter.obterClientePorId("1");

        // Assert
        assertEquals(cliente, result);
        verify(repository, times(1)).findById("1");
        verify(mapper, times(1)).paraCliente(clienteDocument);
    }

    @Test
    void obterClientePorId_deveLancarExcecaoQuandoClienteNaoEncontrado() {
        // Arrange
        when(repository.findById("1")).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ClienteNaoEncontradoException.class, () -> adapter.obterClientePorId("1"));
        verify(repository, times(1)).findById("1");
    }

    @Test
    void obterTodosClientes_deveRetornarListaDeClientes() {
        // Arrange
        Endereco endereco = new Endereco("Rua A", "123", "Apto 1", "Centro", "São Paulo", "SP", "12345-678");
        Cliente cliente = new Cliente("1", "João", "123456789", "CPF", "12345678901", "joao@example.com", LocalDate.now(), "M", endereco);
        ClienteDocument clienteDocument = new ClienteDocument("1", "João", "123456789", "CPF", "12345678901", "joao@example.com", LocalDate.now(), "M", endereco);

        when(repository.findAll()).thenReturn(Collections.singletonList(clienteDocument));
        when(mapper.paraCliente(clienteDocument)).thenReturn(cliente);

        // Act
        List<Cliente> result = adapter.obterTodosClientes();

        // Assert
        assertEquals(1, result.size());
        assertEquals(cliente, result.get(0));
        verify(repository, times(1)).findAll();
        verify(mapper, times(1)).paraCliente(clienteDocument);
    }

    @Test
    void atualizarCliente_deveRetornarClienteAtualizado() {
        // Arrange
        Endereco endereco = new Endereco("Rua A", "123", "Apto 1", "Centro", "São Paulo", "SP", "12345-678");
        Cliente cliente = new Cliente("1", "João", "123456789", "CPF", "12345678901", "joao@example.com", LocalDate.now(), "M", endereco);
        ClienteDocument clienteDocument = new ClienteDocument("1", "João", "123456789", "CPF", "12345678901", "joao@example.com", LocalDate.now(), "M", endereco);

        when(repository.existsById("1")).thenReturn(true);
        when(mapper.paraClienteDocument(cliente)).thenReturn(clienteDocument);
        when(repository.save(clienteDocument)).thenReturn(clienteDocument);
        when(mapper.paraCliente(clienteDocument)).thenReturn(cliente);

        // Act
        Cliente result = adapter.atualizarCliente("1", cliente);

        // Assert
        assertEquals(cliente, result);
        verify(repository, times(1)).existsById("1");
        verify(mapper, times(1)).paraClienteDocument(cliente);
        verify(repository, times(1)).save(clienteDocument);
        verify(mapper, times(1)).paraCliente(clienteDocument);
    }

    @Test
    void atualizarCliente_deveLancarExcecaoQuandoClienteNaoEncontrado() {
        // Arrange
        Endereco endereco = new Endereco("Rua A", "123", "Apto 1", "Centro", "São Paulo", "SP", "12345-678");
        Cliente cliente = new Cliente("1", "João", "123456789", "CPF", "12345678901", "joao@example.com", LocalDate.now(), "M", endereco);

        when(repository.existsById("1")).thenReturn(false);

        // Act & Assert
        assertThrows(ClienteNaoEncontradoException.class, () -> adapter.atualizarCliente("1", cliente));
        verify(repository, times(1)).existsById("1");
    }

    @Test
    void deletarCliente_deveChamarMetodoDeletar() {
        // Arrange
        doNothing().when(repository).deleteById("1");

        // Act
        adapter.deletarCliente("1");

        // Assert
        verify(repository, times(1)).deleteById("1");
    }
}