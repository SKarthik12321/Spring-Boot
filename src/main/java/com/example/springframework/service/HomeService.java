package com.example.springframework.service;

import com.example.springframework.model.Employee;
import com.example.springframework.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    private final EmployeeRepository repo;

    public HomeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public String getMessage() {
        return "Service Layer Working";
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee save(Employee emp) {
        return repo.save(emp);
    }

    public Employee getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}