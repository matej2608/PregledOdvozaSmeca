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
@Table(name="users")
@Data

public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private  long oib;



    @ManyToOne
    @JoinColumn(name="street_id", nullable=false)
    private Street street;

    @ManyToOne
    @JoinColumn(name="relation_id", nullable=false)
    private Relations relations;

    @OneToMany(mappedBy="users")
    private Set<GarbageTypes> garbageTypes;

    
}
