package cl.grupopi.ecommerce.controllers;

import cl.grupopi.ecommerce.entities.Category;
import cl.grupopi.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(category));
    }

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.findAll());
    }

}
