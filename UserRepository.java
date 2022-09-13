package com.citymanager.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.citymanager.app.model.Users;


public interface UserRepository extends JpaRepository<Users, Long> {

   


    
}