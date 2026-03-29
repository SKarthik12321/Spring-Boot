package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class EmployeeDTO {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(value = 1, message = "Salary must be positive")
    private double salary;

    @NotNull(message = "Start date cannot be null")
    private LocalDate startDate;

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}