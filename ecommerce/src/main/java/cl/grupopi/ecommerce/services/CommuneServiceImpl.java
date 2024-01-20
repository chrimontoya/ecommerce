package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Category;
import cl.grupopi.ecommerce.entities.Commune;
import cl.grupopi.ecommerce.repositories.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommuneServiceImpl implements CommuneService {

    @Autowired
    private CommuneRepository communeRepository;
    @Override
    public Commune save(Commune commune) {
        if(commune.getId() != null){
            Optional<Commune> communeOptional = communeRepository.findById(commune.getId());
            if(communeOptional.isPresent()){
                Commune newCommune = communeOptional.orElseThrow();
                newCommune.setName(commune.getName());
                newCommune.setRegion(commune.getRegion());
                return communeRepository.save(newCommune);
            }
        }
        return communeRepository.save(commune);
    }

    @Override
    public Optional<Commune> delete(Long id) {
        Optional<Commune> communeOptional = communeRepository.findById(id);
        communeOptional.ifPresent(commune -> communeRepository.delete(commune));
        return communeOptional;
    }

    @Override
    public Optional<Commune> findById(Long id) {
        return communeRepository.findById(id);
    }

    @Override
    public List<Commune> findAll() {
        return (List<Commune>) communeRepository.findAll();
    }
}
