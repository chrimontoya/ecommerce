package cl.grupopi.ecommerce.controllers;

import cl.grupopi.ecommerce.entities.Marker;
import cl.grupopi.ecommerce.services.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/markers")
public class MarkerController {

    @Autowired
    private MarkerService markerService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Marker marker){
        return ResponseEntity.status(HttpStatus.CREATED).body(markerService.save(marker));
    }
}
