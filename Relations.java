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
@Table(name="relations")
@Data

public class Relations {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "street_id", nullable = false)
    private Street street;


    @OneToMany(mappedBy="users")
    private Set<Users> users;


    @OneToMany(mappedBy="relations")
    private Set<RelationTermins> relationTermins;

    @OneToMany(mappedBy="relations")
    private Set<Employee> employees;

    


}

