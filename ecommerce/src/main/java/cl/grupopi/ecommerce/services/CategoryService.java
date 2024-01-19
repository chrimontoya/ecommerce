package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category save(Category category);
    List<Category> findAll();
    Optional<Category> findById(Long id);
    Optional<Category> delete(Long id);

}
