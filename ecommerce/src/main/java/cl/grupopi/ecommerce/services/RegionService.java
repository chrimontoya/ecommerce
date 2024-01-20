package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Region;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface RegionService {
    Region save(Region region);
    Optional<Region> delete(Long id);
    Optional<Region> findById(Long id);
    List<Region> findAll();
}
