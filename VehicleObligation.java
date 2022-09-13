package com.citymanager.app.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="vehicle_obligation")
@Data

public class VehicleObligation {










    @OneToMany(mappedBy="vehicle_obligation")
    private Set<Vehicle> vehicles;

    @OneToMany(mappedBy="vehicle_obligation")
    private Set<Employee> employees;

    
}
