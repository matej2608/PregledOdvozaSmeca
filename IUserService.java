package com.citymanager.app.service;

import java.util.List;

import com.citymanager.app.model.Users;

public interface IUserService {

    Users findById(long id);
    List<Users> findAll();
    boolean delete(long id);
    Users create(Users user);
    Users update(long id, Users formData);
    
}
