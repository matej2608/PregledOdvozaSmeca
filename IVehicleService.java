package com.citymanager.app.service;

import java.util.List;

import com.citymanager.app.model.Vehicle;

public interface IVehicleService {
    Vehicle findById(long id);
    List<Vehicle> findAll();
    boolean delete(long id);
    Vehicle create(Vehicle vehicle);
    Vehicle update(long id, Vehicle formData);

}