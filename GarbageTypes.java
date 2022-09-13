package com.citymanager.app.model;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.Data;

@Entity
@Table(name="garbage_types")
@Data

public class GarbageTypes {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy="garbage_types")
    private Set<RelationTermins> relationTermins;
    
    @ManyToOne
    @JoinColumn(name="garbageType_id")
    private Users users;

    @OneToMany(mappedBy="garbage_types")
    private Set<Vehicle> vehicle;
    
}