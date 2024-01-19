package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Address;
import cl.grupopi.ecommerce.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<Address> saveAll(List<Address> addresses) {
        return (List<Address>) addressRepository.saveAll(addresses);
    }
}
