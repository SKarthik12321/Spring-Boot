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

    @PutMapping("/update")
    public Employee update(@RequestBody Employee emp) {
        return repo.save(emp);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Deleted";
    }
}