package com.bridgelabz.employeepayrollapp;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    private final EmployeeRepository repo;

    public EmployeePayrollController(EmployeeRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String test() {
        return "Employee Payroll Service Running";
    }

    @GetMapping
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @GetMapping("/get/{id}")
    public Employee getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping("/create")
    public Employee create(@RequestBody Employee emp) {
        return repo.save(emp);
    }


    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
        Employee existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(emp.getName());
            existing.setSalary(emp.getSalary());
            return repo.save(existing);
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Deleted";
    }
}