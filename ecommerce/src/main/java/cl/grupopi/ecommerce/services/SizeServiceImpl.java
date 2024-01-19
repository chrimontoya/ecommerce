package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Size;
import cl.grupopi.ecommerce.repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public Size save(Size size) {
        if(size.getId() != null){
            Optional<Size> sizeOptional = sizeRepository.findById(size.getId());
            if(sizeOptional.isPresent()){
                Size newSize = sizeOptional.orElseThrow();
                newSize.setName(size.getName());
                newSize.setDescription(size.getDescription());
                return sizeRepository.save(newSize);
            }
        }
        return sizeRepository.save(size);
    }

    @Override
    public Optional<Size> delete(Long id) {
        Optional<Size> sizeOptional = sizeRepository.findById(id);
        sizeOptional.ifPresent(size -> sizeRepository.delete(size));
        return sizeOptional;
    }

    @Override
    public Optional<Size> findById(Long id) {
        return sizeRepository.findById(id);
    }

    @Override
    public List<Size> findAll() {
        return (List<Size>) sizeRepository.findAll();
    }
}
