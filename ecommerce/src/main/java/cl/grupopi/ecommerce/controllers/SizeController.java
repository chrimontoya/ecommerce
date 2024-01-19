package cl.grupopi.ecommerce.controllers;

import cl.grupopi.ecommerce.entities.Size;
import cl.grupopi.ecommerce.repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sizes")
public class SizeController {

    @Autowired
    private SizeRepository sizeRepository;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Size size){
        return ResponseEntity.status(HttpStatus.CREATED).body(sizeRepository.save(size));
    }
}
