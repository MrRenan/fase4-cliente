package br.com.fiap.fase4cliente.domain.cliente.repositories;

import br.com.fiap.fase4cliente.domain.cliente.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID> {
}
