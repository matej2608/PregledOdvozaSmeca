package com.citymanager.app.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Table(name="relation_termins")
@Data

public class RelationTermins {


    private String relationStart;
    private String relationFinish;

    

    @ManyToOne
    @JoinColumn(name = "relations_id", nullable = false)
    private Relations Relations;

    @ManyToOne
    @JoinColumn(name="garbageType_id")
    private GarbageTypes garbageTypes;

    
}