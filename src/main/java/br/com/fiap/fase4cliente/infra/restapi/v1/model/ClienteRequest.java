package br.com.fiap.fase4cliente.infra.restapi.v1.model;

import br.com.fiap.fase4cliente.features.domain.entity.Endereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Builder
@Schema(title = "ClienteV1ClienteRequest")
public record ClienteRequest(

        @Id String id,
        String nome,
        String telefone,
        LocalDate dataNascimento,
        String genero,
        Endereco endereco
) {
    @Builder
    @Schema(title = "ClienteV1ClienteRequest#Endereco")
    public record EnderecoRequest(
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
