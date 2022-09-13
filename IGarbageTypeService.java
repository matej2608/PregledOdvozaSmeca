package com.citymanager.app.service;

import java.util.List;

import com.citymanager.app.model.GarbageTypes;

public interface IGarbageTypeService {

    GarbageTypes findById(long id);
    List<GarbageTypes> findAll();
    boolean delete(long id);
    GarbageTypes create(GarbageTypes garbageType);
    GarbageTypes update(long id, GarbageTypes formData);


    
}