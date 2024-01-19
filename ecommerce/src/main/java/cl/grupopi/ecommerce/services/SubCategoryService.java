package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.SubCategory;

import java.util.List;
import java.util.Optional;

public interface SubCategoryService {

    SubCategory save(SubCategory subCategory);
    List<SubCategory> findAll();
    Optional<SubCategory> findById(Long id);
    Optional<SubCategory> delete(Long id);
}
