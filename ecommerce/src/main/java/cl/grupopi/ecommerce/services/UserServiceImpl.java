package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Role;
import cl.grupopi.ecommerce.entities.User;
import cl.grupopi.ecommerce.repositories.RolRepository;
import cl.grupopi.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }
    @Transactional
    @Override
    public User save(User user) {
        Optional<Role> optionalRolUser = rolRepository.findByName("ROLE_USER");
        List<Role> roleList = new ArrayList<>();

        optionalRolUser.ifPresent(roleList::add);

        if(user.isAdmin()){
            Optional<Role> optionalRolAdmin = rolRepository.findByName("ROLE_ADMIN");
            optionalRolAdmin.ifPresent(roleList::add);
        }
        user.setRoles(roleList);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
