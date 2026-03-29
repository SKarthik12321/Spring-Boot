package com.bridgelabz.employeepayrollapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double salary;

    public Employee() {}

    public Long getId() { return id; }

    public String getName() { return name; }

    public double getSalary() { return salary; }

    public void setName(String name) { this.name = name; }

    public void setSalary(double salary) { this.salary = salary; }
}