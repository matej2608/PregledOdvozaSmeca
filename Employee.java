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
@Table(name="employee")
@Data

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private Long oib;
    private String email;

    @ManyToOne
    @JoinColumn(name="relations_id")
    private Relations relations;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private VehicleObligation vehicleObligation;

}
