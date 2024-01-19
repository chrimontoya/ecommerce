package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client save(Client client);
    Optional<Client> findById(Long id);
    Optional<Client> delete(Long id);
    List<Client> findAll();
}
