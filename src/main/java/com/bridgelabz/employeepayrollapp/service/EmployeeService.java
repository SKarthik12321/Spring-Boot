package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employeeList = new ArrayList<>();
    private int idCounter = 1;

    public List<Employee> getAll() {
        return employeeList;
    }

    public Employee getById(int id) {
        return employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Employee create(EmployeeDTO dto) {
        Employee emp = new Employee(dto.getName(), dto.getSalary());
        emp.setId(idCounter++);
        employeeList.add(emp);
        return emp;
    }

    public Employee update(int id, EmployeeDTO dto) {
        Employee emp = getById(id);
        if (emp != null) {
            emp.setName(dto.getName());
            emp.setSalary(dto.getSalary());
        }
        return emp;
    }

    public void delete(int id) {
        employeeList.removeIf(emp -> emp.getId() == id);
    }
}