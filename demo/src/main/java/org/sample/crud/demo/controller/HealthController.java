package org.sample.crud.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HealthController {

    @GetMapping("health")
    public ResponseEntity<Object> getHealth() {
        return new ResponseEntity<>("Servidor online", HttpStatus.OK);
    }

}
