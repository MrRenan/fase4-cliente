package br.com.fiap.fase4cliente.features.domain.exception.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SimpleError {

    private String message;
    private String code;
    private Object object;
    private List<String> details;


    public SimpleError(String message) {
        this.message = message;
    }

}
