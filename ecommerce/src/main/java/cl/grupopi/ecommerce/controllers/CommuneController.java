package cl.grupopi.ecommerce.controllers;

import cl.grupopi.ecommerce.entities.Commune;
import cl.grupopi.ecommerce.services.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/communes")
public class CommuneController {

    @Autowired
    private CommuneService communeService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Commune commune){
        return ResponseEntity.status(HttpStatus.CREATED).body(communeService.save(commune));
    }
}
