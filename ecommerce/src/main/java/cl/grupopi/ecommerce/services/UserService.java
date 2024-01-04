package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User save(User user);
    boolean existsByUsername(String username);

}
