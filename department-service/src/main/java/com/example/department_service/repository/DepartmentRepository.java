package com.example.department_service.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.department_service.entity.Department;

import jakarta.annotation.PostConstruct;

@Component
public class DepartmentRepository {
    
    private List<Department> departments = new ArrayList<>();

    @PostConstruct
    public void init() {
        departments.add(new Department(1L, 1L, "HR"));
        departments.add(new Department(2L, 2L, "IT"));
    }

    public Department add(Department department) {
        department.setId((long) (departments.size() + 1));
        departments.add(department);
        return department;
    }

    public Department findById(Long id) {
        return departments.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Department> findAll() {
        return departments;
    }

    public List<Department> findByOrganization(Long organizationId) {
        return departments.stream().filter(d -> d.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
    }


}
