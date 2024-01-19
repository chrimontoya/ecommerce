package cl.grupopi.ecommerce.repositories;

import cl.grupopi.ecommerce.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
