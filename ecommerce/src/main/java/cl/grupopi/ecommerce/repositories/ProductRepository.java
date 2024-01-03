package cl.grupopi.ecommerce.repositories;

import cl.grupopi.ecommerce.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
