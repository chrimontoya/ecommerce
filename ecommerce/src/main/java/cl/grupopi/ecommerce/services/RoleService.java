package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAllByUsername(String username);
}
