package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Client;
import cl.grupopi.ecommerce.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        if (client.getId() != null) {
            Optional<Client> clientOptional = clientRepository.findById(client.getId());
            if (clientOptional.isPresent()) {
                Client newClient = clientOptional.orElseThrow();
                newClient.setName(client.getName());
                newClient.setLastName(client.getLastName());
                newClient.setRut(client.getRut());
                newClient.setAddresses(client.getAddresses());
                newClient.setMail(client.getMail());
                newClient.setBirthDay(client.getBirthDay());
                newClient.setPhone(client.getPhone());
                return clientRepository.save(newClient);
            }
        }
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Optional<Client> delete(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        clientOptional.ifPresent(client -> clientRepository.delete(client));
        return clientOptional;
    }

    @Override
    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }
}
