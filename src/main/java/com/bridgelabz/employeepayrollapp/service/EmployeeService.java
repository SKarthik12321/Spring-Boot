package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAll() {
        return repository.findAll();
    }


    public Employee create(EmployeeDTO dto) {
        Employee emp = new Employee(dto.getName(), dto.getSalary(), dto.getStartDate());
        return repository.save(emp);
    }

    // replace getById + update + delete parts

    public Employee getById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    public Employee update(int id, EmployeeDTO dto) {
        Employee emp = getById(id);
        emp.setName(dto.getName());
        emp.setSalary(dto.getSalary());
        emp.setStartDate(dto.getStartDate());
        return repository.save(emp);
    }

    public void delete(int id) {
        Employee emp = getById(id);
        repository.delete(emp);
    }
}
