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

import com.citymanager.app.model.Vehicle;
import com.citymanager.app.service.IVehicleService;

@RestController
public class VehicleController {

    private IVehicleService vehicleService;

    public VehicleController(IVehicleService vs) {
        super();
        this.vehicleService = vs;
    }

    @GetMapping("/api/vehicles")
    public List<Vehicle> findAll() {
        List<Vehicle> vehicles = this.vehicleService.findAll();
        return vehicles;
    }

    @GetMapping("/api/vehicles/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Vehicle vehicle = this.vehicleService.findById(id);
        if (vehicle == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Vehicle with id " + id + " not found");
        }
        return ResponseEntity.ok(vehicle);
    }

    @DeleteMapping("/api/vehicle/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        boolean success = this.vehicleService.delete(id);
        if(!success) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Vehicle with id " + id + " not found");
        }

        return ResponseEntity.ok(true);
    }

    @PostMapping("/api/vehicles")
    public ResponseEntity<?> create(@RequestBody Vehicle vehicle) {
        Vehicle newVehicle = this.vehicleService.create(vehicle);
        return ResponseEntity.ok(newVehicle);
    }

    @PutMapping("/api/vehicles/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Vehicle formData) {
        Vehicle updatedVehicle = this.vehicleService.update(id, formData);
        if (updatedVehicle == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Vehicle with id " + id + " not found");
        }
        return ResponseEntity.ok(updatedVehicle);
    }




    
}