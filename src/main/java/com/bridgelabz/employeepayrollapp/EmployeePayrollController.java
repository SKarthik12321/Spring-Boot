package com.bridgelabz.employeepayrollapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeePayrollController {

    @GetMapping("/")
    public String sayHello() {
        return "Employee Payroll App Running";
    }
}
