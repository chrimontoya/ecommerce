package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    Optional<Product> delete(Product product);
}
