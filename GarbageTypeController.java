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

import com.citymanager.app.model.GarbageTypes;
import com.citymanager.app.service.IGarbageTypeService;

@RestController
public class GarbageTypeController {

    private IGarbageTypeService garbagetypeService;

    public GarbageTypeController(IGarbageTypeService gts) {
        super();
        this.garbagetypeService = gts;
    }

    @GetMapping("/api/garbage_types")
    public List<GarbageTypes> findAll() {
        List<GarbageTypes> garbagetypes = this.garbagetypeService.findAll();
        return garbagetypes;
    }

    @GetMapping("/api/garbage_types/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        GarbageTypes garbagetype = this.garbagetypeService.findById(id);
        if (garbagetype == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Garbage type with id " + id + " not found");
        }
        return ResponseEntity.ok(garbagetype);
    }

    @DeleteMapping("/api/garbage_types/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        boolean success = this.garbagetypeService.delete(id);
        if(!success) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Garbage type with id " + id + " not found");
        }

        return ResponseEntity.ok(true);
    }

    @PostMapping("/api/garbage_types")
    public ResponseEntity<?> create(@RequestBody GarbageTypes garbagetype) {
        GarbageTypes newGarbageType = this.garbagetypeService.create(garbagetype);
        return ResponseEntity.ok(newGarbageType);
    }

    @PutMapping("/api/garbage_types/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody GarbageTypes formData) {
        GarbageTypes updatedGarbageType = this.garbagetypeService.update(id, formData);
        if (updatedGarbageType == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Garbage type with id " + id + " not found");
        }
        return ResponseEntity.ok(updatedGarbageType);
    }


    
}