package br.com.fiap.fase4cliente.features.adapter.in.v1.mapper;

import br.com.fiap.fase4cliente.features.domain.entity.Cliente;
import br.com.fiap.fase4cliente.infra.restapi.v1.model.ClienteRequest;
import br.com.fiap.fase4cliente.infra.restapi.v1.model.ClienteResponse;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@AnnotateWith(
        value = Component.class,
        elements = @AnnotateWith.Element(strings = "featuresAdapterInMapperClienteMapperImpl")
)
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "id", target = "id")
    ClienteResponse paraClienteResponse(Cliente cliente);

    @Mapping(source = "nome", target = "nome")
    Cliente paraCliente(ClienteRequest clienteRequest);

}