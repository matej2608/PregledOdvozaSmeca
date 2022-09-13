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

import com.citymanager.app.model.Users;
import com.citymanager.app.service.IUserService;

@RestController
public class UserController {
    private IUserService userService;

    public UserController(IUserService us) {
        super();
        this.userService = us;
    }

    @GetMapping("/api/users")
    public List<Users> findAll() {
        List<Users> users = this.userService.findAll();
        return users;
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Users user = this.userService.findById(id);
        if (user == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("User with id " + id + " not found");
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        boolean success = this.userService.delete(id);
        if(!success) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("User with id " + id + " not found");
        }

        return ResponseEntity.ok(true);
    }

    @PostMapping("/api/users")
    public ResponseEntity<?> create(@RequestBody Users user) {
        Users newUser = this.userService.create(user);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Users formData) {
        Users updatedUser = this.userService.update(id, formData);
        if (updatedUser == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("User with id " + id + " not found");
        }
        return ResponseEntity.ok(updatedUser);
    }
}
