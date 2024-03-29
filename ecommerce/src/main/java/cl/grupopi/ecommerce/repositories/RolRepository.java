package cl.grupopi.ecommerce.repositories;

import cl.grupopi.ecommerce.entities.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RolRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
