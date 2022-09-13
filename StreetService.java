package com.citymanager.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citymanager.app.model.Street;
import com.citymanager.app.repository.StreetRepository;
import com.citymanager.app.service.IStreetService;



@Service
public class StreetService implements IStreetService {

    private StreetRepository streets;

    public StreetService(StreetRepository sr) {
        super();
        this.streets = sr;
    }

    @Override
    public Street findById(long id) {
        try {
            return this.streets.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean delete(long id) {
        Street s = this.findById(id);
        try {
            this.streets.delete(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    @Override
    public Street create(Street s){
        s = this.streets.save(s);
        return s;
    }

    @Override
    public Street update(long id, Street formData) {
        Street oldStreet = this.findById(id);

        if (oldStreet == null) {
            return null;
        }

        oldStreet.setName(formData.getName());
        

        return this.streets.save(oldStreet);
    }

    @Override
    public List<Street> findAll() {
        return this.streets.findAll();
    }

 

    



    
}