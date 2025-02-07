package br.com.fiap.fase4cliente.application.cliente.usecases;

import br.com.fiap.fase4cliente.domain.cliente.entities.ClienteEntity;
import br.com.fiap.fase4cliente.domain.cliente.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ClienteUseCase {


    final ClienteRepository clienteRepository;
    //final UserProducer userProducer;

    public ClienteUseCase(ClienteRepository clienteRepository){//, UserProducer userProducer) {
        this.clienteRepository = clienteRepository;
        //this.userProducer = userProducer;
    }

 @Transactional
    public ClienteEntity save(ClienteEntity clienteEntity) {
        clienteEntity = clienteRepository.save(clienteEntity);
        //userProducer.publishMessageEmail(userModel);
        return clienteEntity;

    }
}
