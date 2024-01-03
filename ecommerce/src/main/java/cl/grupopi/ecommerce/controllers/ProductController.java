package cl.grupopi.ecommerce.controllers;

import cl.grupopi.ecommerce.entities.Product;
import cl.grupopi.ecommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public List<Product> getAll(){
        return productService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id){
        Optional<Product> productOptional = productService.findById(id);
        if(productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Product product, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return validation(bindingResult);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@Valid @RequestBody Product product, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return validation(bindingResult);
        }
        Optional<Product> productOptional = productService.update(id, product);
        if(productOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Product> productOptional = productService.delete(id);
        if(productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> validation(BindingResult bindingResult){
        Map<String, String> errors = new HashMap<>();

        bindingResult.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "Campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
