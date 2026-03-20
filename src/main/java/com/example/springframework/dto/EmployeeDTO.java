package com.example.springframework.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class EmployeeDTO {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(value = 1000, message = "Salary must be at least 1000")
    private double salary;

    public String getName() { return name; }
    public double getSalary() { return salary; }

    public void setName(String name) { this.name = name; }
    public void setSalary(double salary) { this.salary = salary; }
}