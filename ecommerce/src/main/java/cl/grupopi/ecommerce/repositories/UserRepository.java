package cl.grupopi.ecommerce.repositories;

import cl.grupopi.ecommerce.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
