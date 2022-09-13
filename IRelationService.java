package com.citymanager.app.service;

import java.util.List;

import com.citymanager.app.model.Relations;

public interface IRelationService {
    Relations findById(long id);
    List<Relations> findAll();
    boolean delete(long id);
    Relations create(Relations relation);
    Relations update(long id, Relations formData);
}

