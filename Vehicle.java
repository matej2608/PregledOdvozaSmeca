package com.citymanager.app.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="vehicles")
@Data

public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String model;
    private String  registrationMark;
    

    @ManyToOne
    @JoinColumn(name="garbageType_id")
    private GarbageTypes garbageTypes;

    @ManyToOne
    @JoinColumn(name="vehicle_id")
    private VehicleObligation vehicleObligation;

}