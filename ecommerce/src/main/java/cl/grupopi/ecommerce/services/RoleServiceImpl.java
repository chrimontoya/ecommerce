package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Role;
import cl.grupopi.ecommerce.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> findAllByUsername(String username) {
        return roleRepository.findAllByUsername(username);
    }
}
