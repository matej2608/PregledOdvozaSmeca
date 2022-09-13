package com.citymanager.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citymanager.app.model.Vehicle;

public interface VehicleRepository  extends JpaRepository<Vehicle, Long> {

    
}