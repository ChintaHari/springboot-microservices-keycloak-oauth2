package com.example.department_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.department_service.client.EmployeeClient;
import com.example.department_service.entity.Department;
import com.example.department_service.repository.DepartmentRepository;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;
    
    @GetMapping("/all")
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @PostMapping("/addDepartment")
    public Department addDepartment(@RequestBody Department department) {
        return departmentRepository.add(department);
    }   
    
    @GetMapping("/{organizationId}")
    public List<Department> findByOrganization(@PathVariable("organizationId") Long organizationId) {
        return departmentRepository.findByOrganization(organizationId);
    }

    @GetMapping("/organization/{organizationId}/employees")
    public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId) {
            List<Department> departments = departmentRepository.findByOrganization(organizationId);
            departments.forEach(d -> d.setEmployees(employeeClient.findByDepartmentId(d.getId())));
            return departments;
    }
}
