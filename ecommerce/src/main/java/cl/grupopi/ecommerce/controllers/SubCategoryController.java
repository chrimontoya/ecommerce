package cl.grupopi.ecommerce.controllers;

import cl.grupopi.ecommerce.entities.SubCategory;
import cl.grupopi.ecommerce.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/subCategories")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody SubCategory subCategory){
        return ResponseEntity.status(HttpStatus.CREATED).body(subCategoryService.save(subCategory));
    }
}
