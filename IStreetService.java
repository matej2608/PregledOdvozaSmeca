package com.citymanager.app.service;

import java.util.List;

import com.citymanager.app.model.Street;



public interface IStreetService {
    Street findById(long id);
    List<Street> findAll();
    boolean delete(long id);
    Street create(Street street);
    Street update(long id, Street formData);
    
    
}