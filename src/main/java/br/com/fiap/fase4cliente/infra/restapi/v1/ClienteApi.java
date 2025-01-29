package br.com.fiap.fase4cliente.infra.restapi.v1;

import br.com.fiap.fase4cliente.infra.restapi.v1.model.ClienteRequest;
import br.com.fiap.fase4cliente.infra.restapi.v1.model.ClienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Tag(name = "Cliente", description = "Operações relacionadas ao dominio de cliente")
@RequestMapping(path = ("/v1/cliente"))
public interface ClienteApi {

    @Operation(summary = "Criar cliente.")
    @PostMapping
    @ResponseStatus(CREATED)
    ClienteResponse criarCliente(@RequestBody ClienteRequest cliente);

    @Operation(summary = "Obter cliente por id")
    @GetMapping("/{idCliente}")
    @ResponseStatus(OK)
    ClienteResponse obterClientePorId(@PathVariable("idCliente") String idCliente);

    @Operation(summary = "Obter todos os clientes.")
    @GetMapping
    @ResponseStatus(OK)
    List<ClienteResponse> obterTodosClientes();

    @Operation(summary = "Atualizar um cliente por id.")
    @PutMapping("/{idCliente}")
    @ResponseStatus(OK)
    ClienteResponse atualizarCliente(@PathVariable String idCliente, @RequestBody ClienteRequest cliente);

    @Operation(summary = "Deletar um cliente por id")
    @DeleteMapping("/{idCliente}")
    @ResponseStatus(NO_CONTENT)
    void deletarCliente(@PathVariable String idCliente);

}
