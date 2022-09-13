package com.citymanager.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citymanager.app.model.GarbageTypes;

public interface GarbageTypeRepository extends JpaRepository<GarbageTypes, Long> {


    
}