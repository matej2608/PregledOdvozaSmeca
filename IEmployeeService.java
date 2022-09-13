package com.citymanager.app.service;

import java.util.List;

import com.citymanager.app.model.Employee;

public interface IEmployeeService {

    Employee findById(long id);
    List<Employee> findAll();
    boolean delete(long id);
    Employee create(Employee Employee);
    Employee update(long id, Employee formData);
    
}
