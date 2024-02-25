package cl.grupopi.ecommerce.repositories;

import cl.grupopi.ecommerce.entities.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long> {

    @Query("SELECT u.roles FROM User u WHERE u.username = ?1")
    List<Role> findAllByUsername(String username);

}
