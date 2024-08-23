package com.example.department_service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.department_service.entity.Employee;

@FeignClient(name = "EMPLOYEE-SERVICE", url = "http://localhost:8081/employees")
public interface EmployeeClient {

    @GetMapping("/department/{departmentId}")
    List<Employee> findByDepartmentId(@PathVariable("departmentId") Long departmentId);
    
}
