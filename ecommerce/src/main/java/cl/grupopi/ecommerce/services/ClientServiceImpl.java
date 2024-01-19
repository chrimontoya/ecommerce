package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Address;
import cl.grupopi.ecommerce.entities.Client;
import cl.grupopi.ecommerce.repositories.AddressRepository;
import cl.grupopi.ecommerce.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }
}
