package cl.grupopi.ecommerce.repositories;

import cl.grupopi.ecommerce.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
