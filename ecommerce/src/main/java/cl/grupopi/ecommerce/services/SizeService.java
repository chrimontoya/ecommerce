package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Size;

import java.util.List;
import java.util.Optional;

public interface SizeService {
    Size save(Size size);
    Optional<Size> delete(Long id);
    Optional<Size> findById(Long id);
    List<Size> findAll();
}
