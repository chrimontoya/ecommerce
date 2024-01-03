package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Rol;
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
public class UserServiceImpl implements UserService{

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
        Optional<Rol> optionalRolUser = rolRepository.findByName("ROL_USER");
        List<Rol> rolList = new ArrayList<>();

        optionalRolUser.ifPresent(rolList::add);

        if(user.isAdmin()){
            Optional<Rol> optionalRolAdmin = rolRepository.findByName("ROL_ADMIN");
            optionalRolAdmin.ifPresent(rolList::add);
        }
        user.setRolList(rolList);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
}
