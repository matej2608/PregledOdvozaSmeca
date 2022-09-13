package com.citymanager.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citymanager.app.model.Relations;
import com.citymanager.app.repository.RelationRepository;
import com.citymanager.app.service.IRelationService;

@Service
public class RelationService implements IRelationService {

    private RelationRepository relations;

    public RelationService(RelationRepository rr) {
        super();
        this.relations = rr;
    }

    @Override
    public Relations findById(long id) {
        try {
            return this.relations.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Relations> findAll() {
        return this.relations.findAll();
    }

    @Override
    public boolean delete(long id) {
        Relations r = this.findById(id);
        try {
            this.relations.delete(r);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Relations create(Relations r) {
        r = this.relations.save(r);
        return r;
    }

    @Override
    public Relations update(long id, Relations formData) {
        Relations oldRelation = this.findById(id);

        if (oldRelation == null) {
            return null;
        }

        oldRelation.setName(formData.getName());
        

        return this.relations.save(oldRelation);
    }

  

    
}
