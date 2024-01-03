package cl.grupopi.ecommerce.repositories;

import cl.grupopi.ecommerce.entities.Rol;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RolRepository extends CrudRepository<Rol, Long> {

    Optional<Rol> findByName(String name);
}
