package com.citymanager.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citymanager.app.model.Users;
import com.citymanager.app.repository.UserRepository;
import com.citymanager.app.service.IUserService;

@Service
public class UserService implements IUserService {

    private UserRepository users;

    public UserService(UserRepository ur) {
        super();
        this.users = ur;
    }

    @Override
    public Users findById(long id) {
        try {
            return this.users.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Users> findAll() {
        return this.users.findAll();
    }

    @Override
    public boolean delete(long id) {
        Users u = this.findById(id);
        try {
            this.users.delete(u);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Users create(Users u) {
        u = this.users.save(u);
        return u;
    }

    @Override
    public Users update(long id, Users formData) {
        Users oldUser = this.findById(id);

        if (oldUser == null) {
            return null;
        }

        return this.users.save(oldUser);
    }

   
  

  
    }

  


    

