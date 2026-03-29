package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Employee create(EmployeeDTO dto) {
        Employee emp = new Employee(dto.getName(), dto.getSalary(), dto.getStartDate());
        return repository.save(emp);
    }

    public Employee update(int id, EmployeeDTO dto) {
        Employee emp = repository.findById(id).orElse(null);
        if (emp != null) {
            emp.setName(dto.getName());
            emp.setSalary(dto.getSalary());
            emp.setStartDate(dto.getStartDate());
            return repository.save(emp);
        }
        return null;
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}