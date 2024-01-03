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
    @Transactional
    @Override
    public Optional<Product> delete(Product product) {
        Optional<Product> productExist = productRepository.findById(product.getId());
        productExist.ifPresent(product1 -> {
            productRepository.delete(product);
        });
        return productExist;
    }
}
