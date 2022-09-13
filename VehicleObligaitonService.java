package com.citymanager.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citymanager.app.model.VehicleObligation;
import com.citymanager.app.repository.VehicleObligationRepository;
import com.citymanager.app.service.IVehicleObligationService;

@Service
public class VehicleObligaitonService implements IVehicleObligationService {

    private VehicleObligationRepository vehicleObligation;

    public VehicleObligaitonService(VehicleObligationRepository vor) {
        super();
        this.vehicleObligation = vor;
    }

    @Override
    public VehicleObligation findById(long id) {
        try {
            return this.vehicleObligation.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<VehicleObligation> findAll() {
        return this.vehicleObligation.findAll();
    }
    
}