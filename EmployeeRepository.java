package com.citymanager.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citymanager.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
