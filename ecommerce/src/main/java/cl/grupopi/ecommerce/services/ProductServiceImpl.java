package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Product;
import cl.grupopi.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    @Transactional
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            Product productExist = productOptional.orElseThrow();
            productExist.setName(product.getName());
            productExist.setDescription(product.getDescription());
            productExist.setPrice(product.getPrice());
            productExist.setSubCategory(product.getSubCategory());
            productExist.setMarker(product.getMarker());
            productExist.setSize(product.getSize());
            return Optional.of(productRepository.save(product));
        }
        return productOptional;
    }

    @Transactional
    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        productOptional.ifPresent(productExist -> productRepository.delete(productExist));
        return productOptional;
    }
}
