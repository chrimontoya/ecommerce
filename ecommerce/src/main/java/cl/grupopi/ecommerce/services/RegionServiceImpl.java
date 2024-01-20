package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Region;
import cl.grupopi.ecommerce.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository regionRepository;
    @Override
    public Region save(Region region) {
        if(region.getId() != null){
            Optional<Region> regionOptional = regionRepository.findById(region.getId());
            if(regionOptional.isPresent()){
                Region newRegion = regionOptional.orElseThrow();
                newRegion.setName(region.getName());
                return regionRepository.save(newRegion);
            }
        }
        return regionRepository.save(region);
    }

    @Override
    public Optional<Region> delete(Long id) {
        Optional<Region> regionOptional = regionRepository.findById(id);
        regionOptional.ifPresent(region -> regionRepository.delete(region));
        return regionOptional;
    }

    @Override
    public Optional<Region> findById(Long id) {
        return regionRepository.findById(id);
    }

    @Override
    public List<Region> findAll() {
        return (List<Region>) regionRepository.findAll();
    }
}
