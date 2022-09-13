package com.citymanager.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citymanager.app.model.Employee;
import com.citymanager.app.repository.EmployeeRepository;
import com.citymanager.app.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

    private EmployeeRepository employees;

    public EmployeeService(EmployeeRepository er) {
        super();
        this.employees = er;
    }

    @Override
    public Employee findById(long id) {
        try {
            return this.employees.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Employee> findAll() {
        return this.employees.findAll();
    }

    @Override
    public boolean delete(long id) {
        Employee em = this.findById(id);
        try {
            this.employees.delete(em);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Employee create(Employee e) {
        e = this.employees.save(e);
        return e;
    }

    @Override
    public Employee update(long id, Employee formData) {
        Employee oldEmployee = this.findById(id);

        if (oldEmployee == null) {
            return null;
        }

        oldEmployee.setFirstName(formData.getFirstName());
        oldEmployee.setLastName(formData.getLastName());

        return this.employees.save(oldEmployee);
    }


    
}
