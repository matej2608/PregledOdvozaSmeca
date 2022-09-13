package com.citymanager.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citymanager.app.model.VehicleObligation;

public interface VehicleObligationRepository extends JpaRepository<VehicleObligation, Long> {
    
}
