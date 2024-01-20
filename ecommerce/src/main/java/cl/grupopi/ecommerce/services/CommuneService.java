package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Commune;

import java.util.List;
import java.util.Optional;

public interface CommuneService {
    Commune save(Commune commune);
    Optional<Commune> delete(Long id);
    Optional<Commune> findById(Long id);
    List<Commune> findAll();
}
