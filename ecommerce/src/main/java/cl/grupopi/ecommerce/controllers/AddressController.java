package cl.grupopi.ecommerce.controllers;

import cl.grupopi.ecommerce.entities.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Address address){
        return ResponseEntity.status(HttpStatus.CREATED).body(address);
    }
}
