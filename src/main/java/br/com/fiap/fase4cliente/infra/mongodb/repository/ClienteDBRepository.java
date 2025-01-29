package br.com.fiap.fase4cliente.infra.mongodb.repository;

import br.com.fiap.fase4cliente.infra.mongodb.document.cliente.ClienteDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDBRepository extends MongoRepository<ClienteDocument, String> {
}
