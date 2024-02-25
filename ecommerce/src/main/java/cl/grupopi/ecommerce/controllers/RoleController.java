package cl.grupopi.ecommerce.controllers;

import cl.grupopi.ecommerce.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/{username}")
    public ResponseEntity<?> findAllByUsername(@PathVariable String username){
        return ResponseEntity.status(HttpStatus.OK).body(roleService.findAllByUsername(username));
    }
}
