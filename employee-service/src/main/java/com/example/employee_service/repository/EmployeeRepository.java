package com.example.employee_service.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.employee_service.entity.Employee;

import jakarta.annotation.PostConstruct;

@Component
public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();

    @PostConstruct
    public void init() {
        employees.add(new Employee(1, 1L, 1L, "John Smith", 34, "Analyst"));
        employees.add(new Employee(2, 1L, 1L, "Darren Hamilton", 37, "Manager"));
        employees.add(new Employee(3, 1L, 1L, "Tom Scott", 26, "Developer"));
        employees.add(new Employee(4, 1L, 2L, "Anna London", 39, "Analyst"));
        employees.add(new Employee(5, 1L, 2L, "Patrick Dempsey", 27, "Developer"));
        employees.add(new Employee(6, 2L, 3L, "Kevin Price", 38, "Developer"));
        employees.add(new Employee(7, 2L, 3L, "Ian Scott", 34, "Developer"));
        employees.add(new Employee(8, 2L, 3L, "Andrew Campton", 30, "Manager"));
        employees.add(new Employee(9, 2L, 4L, "Steve Franklin", 25, "Developer"));
        employees.add(new Employee(1, 2L, 4L, "Elisabeth Smith", 30, "Developer"));
    }

    public List<Employee> findAll() {
        return employees;
    }

    public Employee findById(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public List<Employee> findByDepartmentId(Long departmentId) {
        return employees.stream().filter(e -> e.getDepartmentId().equals(departmentId)).toList();
    }

    public List<Employee> findByOrganizationId(Long organizationId) {
        return employees.stream().filter(e -> e.getOrganizationId().equals(organizationId)).toList();
    }
    
}
