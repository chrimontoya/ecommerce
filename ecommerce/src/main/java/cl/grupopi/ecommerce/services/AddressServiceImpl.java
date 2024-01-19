package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Address;
import cl.grupopi.ecommerce.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public Address save(Address address) {
        if(address.getId() != null){
            Optional<Address> addressOptional = addressRepository.findById(address.getId());
            if(addressOptional.isPresent()){
                Address newAddress = addressOptional.orElseThrow();
                newAddress.setName(address.getName());
                newAddress.setNumber(address.getNumber());
                return addressRepository.save(newAddress);
            }
        }
        return addressRepository.save(address);
    }
    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }
    @Override
    public Optional<Address> delete(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        addressOptional.ifPresent(address -> addressRepository.delete(address));
        return addressOptional;
    }
    @Override
    public List<Address> findAll() {
        return (List<Address>) addressRepository.findAll();
    }
}
