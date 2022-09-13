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

import com.citymanager.app.model.Relations;
import com.citymanager.app.service.IRelationService;

@RestController
public class RelationController {
    private IRelationService relationService;

    public RelationController(IRelationService rs) {
        super();
        this.relationService = rs;
    }

    @GetMapping("/api/relations")
    public List<Relations> findAll() {
        List<Relations> countries = this.relationService.findAll();
        return countries;
    }

    @GetMapping("/api/relations/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Relations relation = this.relationService.findById(id);
        if (relation == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Relation with id " + id + " not found");
        }
        return ResponseEntity.ok(relation);
    }

    @DeleteMapping("/api/relations/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        boolean success = this.relationService.delete(id);
        if(!success) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Relation with id " + id + " not found");
        }

        return ResponseEntity.ok(true);
    }

    @PostMapping("/api/relations")
    public ResponseEntity<?> create(@RequestBody Relations relation) {
        Relations newRelation = this.relationService.create(relation);
        return ResponseEntity.ok(newRelation);
    }

    @PutMapping("/api/relations/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Relations formData) {
        Relations updatedRelation = this.relationService.update(id, formData);
        if (updatedRelation == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Relation with id " + id + " not found");
        }
        return ResponseEntity.ok(updatedRelation);
    }
}
