package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.Category;
import cl.grupopi.ecommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category save(Category category) {
        Optional<Category> categoryOptional = categoryRepository.findById(category.getId());
        if(categoryOptional.isPresent()){
            Category newCategory = categoryOptional.orElseThrow();
            newCategory.setName(category.getName());
            newCategory.setSubCategory(category.getSubCategory());
            return categoryRepository.save(newCategory);
        }
        return categoryRepository.save(category);
    }
    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }
    @Override
    public Optional<Category> delete(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        categoryOptional.ifPresent(category -> categoryRepository.delete(category));
        return categoryOptional;
    }
}
