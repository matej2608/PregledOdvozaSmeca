package com.citymanager.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citymanager.app.model.Street;

public interface StreetRepository extends JpaRepository<Street, Long>{

    
}