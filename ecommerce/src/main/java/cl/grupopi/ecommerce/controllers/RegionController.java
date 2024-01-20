package cl.grupopi.ecommerce.controllers;

import cl.grupopi.ecommerce.entities.Region;
import cl.grupopi.ecommerce.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/regions")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Region region){
        return ResponseEntity.status(HttpStatus.CREATED).body(regionService.save(region));
    }
}
