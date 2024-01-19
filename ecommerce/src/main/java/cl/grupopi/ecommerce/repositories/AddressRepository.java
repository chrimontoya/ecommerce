package cl.grupopi.ecommerce.repositories;

import cl.grupopi.ecommerce.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
