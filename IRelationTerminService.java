package com.citymanager.app.service;

import java.util.List;

import com.citymanager.app.model.RelationTermins;



public interface IRelationTerminService {

    List<RelationTermins> findAll();
    RelationTermins create(RelationTermins relationTermins);



    
}
