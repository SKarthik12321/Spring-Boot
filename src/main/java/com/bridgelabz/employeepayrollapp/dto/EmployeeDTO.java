package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

public class EmployeeDTO {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(value = 1, message = "Salary must be greater than 0")
    private double salary;

    public EmployeeDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}