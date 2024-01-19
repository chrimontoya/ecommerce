package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Marker;
import cl.grupopi.ecommerce.repositories.MarkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkerServiceImpl implements MarkerService {

    @Autowired
    private MarkerRepository markerRepository;
    @Override
    public Marker save(Marker marker) {
        if(marker.getId() != null){
            Optional<Marker> markerOptional = markerRepository.findById(marker.getId());
            if(markerOptional.isPresent()){
                Marker newMarker = markerOptional.orElseThrow();
                newMarker.setName(marker.getName());
                newMarker.setProducts(marker.getProducts());
                return markerRepository.save(newMarker);
            }
        }
        return markerRepository.save(marker);
    }

    @Override
    public Optional<Marker> delete(Long id) {
        Optional<Marker> markerOptional = markerRepository.findById(id);
        markerOptional.ifPresent(marker -> markerRepository.delete(marker));
        return markerOptional;
    }

    @Override
    public Optional<Marker> findById(Long id) {
        return markerRepository.findById(id);
    }

    @Override
    public List<Marker> findAll() {
        return (List<Marker>) markerRepository.findAll();
    }
}
