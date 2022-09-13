package com.citymanager.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citymanager.app.model.RelationTermins;
import com.citymanager.app.service.IRelationTerminService;

public class RelationTerminsController {

    @RestController
public class RelationTerminController {
    private IRelationTerminService relationTerminService;

    public RelationTerminController(IRelationTerminService rts) {
        super();
        this.relationTerminService = rts;
    }

    @GetMapping("/api/relation_termins")
    public List<RelationTermins> findAll() {
        List<RelationTermins> cities = this.relationTerminService.findAll();
        return cities;
    }


    
}
}
