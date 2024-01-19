package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Marker;

import java.util.List;
import java.util.Optional;

public interface MarkerService {

    Marker save(Marker marker);
    Optional<Marker> delete(Long id);
    Optional<Marker> findById(Long id);
    List<Marker> findAll();
}
