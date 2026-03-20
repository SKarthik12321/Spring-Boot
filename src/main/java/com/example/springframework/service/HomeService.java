package com.example.springframework.service;

import com.example.springframework.dto.EmployeeDTO;
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

    public Employee getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee saveFromDTO(EmployeeDTO dto) {
        Employee emp = new Employee(dto.getName(), dto.getSalary());
        return repo.save(emp);
    }

    public Employee updateFromDTO(Long id, EmployeeDTO dto) {
        Employee emp = repo.findById(id).orElse(null);
        if (emp != null) {
            emp.setName(dto.getName());
            emp.setSalary(dto.getSalary());
            return repo.save(emp);
        }
        return null;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}