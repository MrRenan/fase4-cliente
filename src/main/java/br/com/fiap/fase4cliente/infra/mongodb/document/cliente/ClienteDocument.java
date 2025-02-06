package br.com.fiap.fase4cliente.infra.mongodb.document.cliente;

import br.com.fiap.fase4cliente.features.domain.entity.Endereco;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Builder
@Document(collection = "cliente")
public record ClienteDocument(

        @Id String id,
        String nome,
        String telefone,
        LocalDate dataNascimento,
        String genero,
        Endereco endereco
) {
    @Builder
    @Document(collection = "endereco")
    public record EnderecoDocument(
            String rua,
            String numero,
            String complemento,
            String bairro,
            String cidade,
            String estado,
            String cep
    ) {

    }

}