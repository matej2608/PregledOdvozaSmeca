package com.citymanager.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citymanager.app.model.Vehicle;
import com.citymanager.app.repository.VehicleRepository;
import com.citymanager.app.service.IVehicleService;

@Service
public class VehicleService implements IVehicleService{

    private VehicleRepository vehicles;

    public VehicleService(VehicleRepository vr) {
        super();
        this.vehicles = vr;
    }

    @Override
    public Vehicle findById(long id) {
        try {
            return this.vehicles.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Vehicle> findAll() {
        return this.vehicles.findAll();
    }

    @Override
    public boolean delete(long id) {
        Vehicle v = this.findById(id);
        try {
            this.vehicles.delete(v);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Vehicle create(Vehicle v) {
        v = this.vehicles.save(v);
        return v;
    }

    @Override
    public Vehicle update(long id, Vehicle formData) {
        Vehicle oldVehicle = this.findById(id);

        if (oldVehicle == null) {
            return null;
        }

        
        oldVehicle.setRegistrationMark(formData.getRegistrationMark());
        oldVehicle.setModel(formData.getModel());
        

        return this.vehicles.save(oldVehicle);

    }
    

}