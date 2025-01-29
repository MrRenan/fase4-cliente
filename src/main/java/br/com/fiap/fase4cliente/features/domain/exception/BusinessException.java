package br.com.fiap.fase4cliente.features.domain.exception;

import br.com.fiap.fase4cliente.features.domain.exception.dto.SimpleError;
import org.springframework.http.HttpStatusCode;

public abstract class BusinessException extends RuntimeException {

    private final HttpStatusCode httpStatusCode;
    private final SimpleError simpleError;


    public BusinessException(HttpStatusCode httpStatusCode, SimpleError simpleError) {
        super(simpleError.getMessage());
        this.httpStatusCode = httpStatusCode;
        this.simpleError = simpleError;
    }

    public HttpStatusCode getStatus() {
        return httpStatusCode;
    }

    public SimpleError getError() {
        return simpleError;
    }
}
