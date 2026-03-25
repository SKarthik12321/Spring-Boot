package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Employee create(EmployeeDTO dto) {
        return repo.save(new Employee(dto.getName(), dto.getSalary()));
    }

    public Employee update(Long id, EmployeeDTO dto) {
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
