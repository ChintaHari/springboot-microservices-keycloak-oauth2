package com.example.employee_service.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    private Long organizationId;
    private Long departmentId;
    private String name;
    private int age;
    private String position;
}
