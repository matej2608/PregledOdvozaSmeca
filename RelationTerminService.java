package com.citymanager.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;


import com.citymanager.app.model.RelationTermins;
import com.citymanager.app.repository.RelationTerminRepository;
import com.citymanager.app.service.IRelationTerminService;



@Service
public class RelationTerminService implements IRelationTerminService {

    private RelationTerminRepository relationTermin;

    public RelationTerminService(RelationTerminRepository rtr) {
        super();
        this.relationTermin = rtr;
    }


    @Override
    public List<RelationTermins> findAll() {
        return this.relationTermin.findAll();
    }

    @Override
    public RelationTermins create(RelationTermins rt) {
        rt = this.relationTermin.save(rt);
        return rt;
    }

    
    
}


    
