package com.citymanager.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citymanager.app.model.RelationTermins;

public interface RelationTerminRepository extends JpaRepository<RelationTermins, Long> {
    
}
