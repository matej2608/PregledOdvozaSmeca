package com.citymanager.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citymanager.app.model.Relations;

public interface RelationRepository extends JpaRepository<Relations, Long> {
    
}
