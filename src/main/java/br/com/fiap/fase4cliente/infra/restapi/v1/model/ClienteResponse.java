package br.com.fiap.fase4cliente.infra.restapi.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(title = "ClienteV1ClienteResponse")
public record ClienteResponse(
        String id,
        String nome
) {

}
