package com.citymanager.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citymanager.app.model.Street;
import com.citymanager.app.service.IStreetService;

@RestController
public class StreetController {

    private IStreetService streetService;

    public StreetController(IStreetService ss) {
        super();
        this.streetService = ss;
    }

    @GetMapping("/api/streets")
    public List<Street> findAll() {
        List<Street> streets = this.streetService.findAll();
        return streets;
    }

    @GetMapping("/api/streets/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Street street = this.streetService.findById(id);
        if (street == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Street with id " + id + " not found");
        }
        return ResponseEntity.ok(street);
    }

    @DeleteMapping("/api/streets/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        boolean success = this.streetService.delete(id);
        if(!success) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Street with id " + id + " not found");
        }

        return ResponseEntity.ok(true);
    }

    @PostMapping("/api/streets")
    public ResponseEntity<?> create(@RequestBody Street street) {
        Street newStreet = this.streetService.create(street);
        return ResponseEntity.ok(newStreet);
    }

    @PutMapping("/api/streets/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Street formData) {
        Street updatedStreet = this.streetService.update(id, formData);
        if (updatedStreet == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Street with id " + id + " not found");
        }
        return ResponseEntity.ok(updatedStreet);
    }

    
    
}