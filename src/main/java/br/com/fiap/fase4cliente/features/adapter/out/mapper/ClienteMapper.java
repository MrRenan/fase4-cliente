package br.com.fiap.fase4cliente.features.adapter.out.mapper;

import br.com.fiap.fase4cliente.features.domain.entity.Cliente;
import br.com.fiap.fase4cliente.infra.mongodb.document.cliente.ClienteDocument;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@AnnotateWith(
        value = Component.class,
        elements = @AnnotateWith.Element(strings = "featuresAdapterOutMapperClienteMapperImpl")
)
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Cliente paraCliente(ClienteDocument cliente);

    ClienteDocument paraClienteDocument(Cliente clienteRequest);
}
