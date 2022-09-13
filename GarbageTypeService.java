package com.citymanager.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citymanager.app.model.GarbageTypes;
import com.citymanager.app.repository.GarbageTypeRepository;
import com.citymanager.app.service.IGarbageTypeService;


@Service
public class GarbageTypeService implements IGarbageTypeService {

    private GarbageTypeRepository garbagetypes;

    public GarbageTypeService(GarbageTypeRepository gtr) {
        super();
        this.garbagetypes = gtr;
    }

    @Override
    public GarbageTypes findById(long id) {
        try {
            return this.garbagetypes.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<GarbageTypes> findAll() {
        return this.garbagetypes.findAll();
    }

    @Override
    public boolean delete(long id) {
        GarbageTypes gt = this.findById(id);
        try {
            this.garbagetypes.delete(gt);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public GarbageTypes create(GarbageTypes gt) {
        gt = this.garbagetypes.save(gt);
        return gt;
    }

    @Override
    public GarbageTypes update(long id, GarbageTypes formData) {
        GarbageTypes oldGarbageType = this.findById(id);

        if (oldGarbageType == null) {
            return null;
        }

        oldGarbageType.setName(formData.getName());
        

        return this.garbagetypes.save(oldGarbageType);
    }
    
}