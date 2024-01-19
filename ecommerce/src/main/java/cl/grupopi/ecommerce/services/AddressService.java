package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Address;

import java.util.List;

public interface AddressService {
    List<Address> saveAll(List<Address> addresses);
}
