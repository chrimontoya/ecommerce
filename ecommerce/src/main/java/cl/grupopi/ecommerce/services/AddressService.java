package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Address save(Address address);
    Optional<Address> findById(Long id);
    Optional<Address> delete(Long id);
    List<Address> findAll();

}
