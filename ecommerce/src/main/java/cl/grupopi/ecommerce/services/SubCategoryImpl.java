package cl.grupopi.ecommerce.services;

import cl.grupopi.ecommerce.entities.SubCategory;
import cl.grupopi.ecommerce.repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryImpl implements SubCategoryService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public SubCategory save(SubCategory subCategory) {
        if(subCategory.getId() != null){
            Optional<SubCategory> subCategoryOptional = subCategoryRepository.findById(subCategory.getId());
            if(subCategoryOptional.isPresent()){
                SubCategory newSubCategory = subCategoryOptional.orElseThrow();
                newSubCategory.setName(subCategory.getName());
                newSubCategory.setProducts(subCategory.getProducts());
                return subCategoryRepository.save(newSubCategory);
            }
        }
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public List<SubCategory> findAll() {
        return (List<SubCategory>) subCategoryRepository.findAll();
    }
    @Override
    public Optional<SubCategory> findById(Long id) {
        return subCategoryRepository.findById(id);
    }
    @Override
    public Optional<SubCategory> delete(Long id) {
        Optional<SubCategory> subCategoryOptional = subCategoryRepository.findById(id);
        subCategoryOptional.ifPresent(subCategory -> subCategoryRepository.delete(subCategory));
        return subCategoryOptional;
    }
}
