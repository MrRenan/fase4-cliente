package br.com.fiap.fase4cliente.infra.mongodb.document.cliente;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "cliente")
public record ClienteDocument(

        @Id String id,
        String nome
) {
}
