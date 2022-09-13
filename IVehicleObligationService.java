package com.citymanager.app.service;

import java.util.List;

import com.citymanager.app.model.VehicleObligation;

public interface IVehicleObligationService {

    VehicleObligation findById(long id);
    List<VehicleObligation> findAll();


    
}
