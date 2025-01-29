package br.com.fiap.fase4cliente.features.domain.exception;

import br.com.fiap.fase4cliente.features.domain.exception.dto.SimpleError;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class ClienteNaoEncontradoException extends BusinessException {

    private static final String CODIGO = "CLIENTE_NAO_ENCONTRADO";
    private static final String MENSAGEM = "Cliente não encontrado";
    private static final String DETALHE = "O cliente informado não foi encontrado.";

    public ClienteNaoEncontradoException(SimpleError simpleError) {
        super(NOT_FOUND, simpleError);
    }

    public static ClienteNaoEncontradoException clienteNaoEncontradoException() {
        var simpleError = new SimpleError(MENSAGEM);
        simpleError.setCode(CODIGO);
        simpleError.setDetails(List.of(DETALHE));
        return new ClienteNaoEncontradoException(simpleError);
    }
}
