package com.citymanager.app.controller;

import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citymanager.app.model.Employee;
import com.citymanager.app.service.IEmployeeService;





@RestController
public class EmployeeController {
    private IEmployeeService employeeService;

    public EmployeeController(IEmployeeService es) {
        super();
        this.employeeService = es;
    }

    @GetMapping("/api/employees")
    public List<Employee> findAll() {
        List<Employee> employees = this.employeeService.findAll();
        return employees;
    }

    @GetMapping("/api/employees/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Employee employee = this.employeeService.findById(id);
        if (employee == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Employee with id " + id + " not found");
        }
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/api/employees/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        boolean success = this.employeeService.delete(id);
        if(!success) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Employee with id " + id + " not found");
        }

        return ResponseEntity.ok(true);
    }

    @PostMapping("/api/employees")
    public ResponseEntity<?> create(@RequestBody Employee employee) {
        Employee newEmployee = this.employeeService.create(employee);
        return ResponseEntity.ok(newEmployee);
    }

    @PutMapping("/api/employees/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Employee formData) {
        Employee updatedEmployee = this.employeeService.update(id, formData);
        if (updatedEmployee == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Employee with id " + id + " not found");
        }
        return ResponseEntity.ok(updatedEmployee);
    }
}