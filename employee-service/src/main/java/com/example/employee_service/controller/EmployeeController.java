package com.example.employee_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_service.entity.Employee;
import com.example.employee_service.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/organization/{organizationId}")
    public List<Employee> findByOrganizationId(@PathVariable("organizationId") Long organizationId) {
        return employeeRepository.findByOrganizationId(organizationId);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartmentId(@PathVariable("departmentId") Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

}
