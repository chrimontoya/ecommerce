package cl.grupopi.ecommerce.controllers;

import cl.grupopi.ecommerce.entities.Client;
import cl.grupopi.ecommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(name = "")
    public ResponseEntity<?> create(@RequestBody Client client){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.clientService.save(client));
    }
}
