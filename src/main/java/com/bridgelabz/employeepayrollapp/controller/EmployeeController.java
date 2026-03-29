package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseDTO getAll() {
        List<Employee> list = service.getAll();
        return new ResponseDTO("Get Call Success", list);
    }

    @GetMapping("/{id}")
    public ResponseDTO getById(@PathVariable int id) {
        Employee emp = service.getById(id);
        return new ResponseDTO("Get By Id Success", emp);
    }

    @PostMapping
    public ResponseDTO create(@Valid @RequestBody EmployeeDTO dto) {
        Employee emp = service.create(dto);
        return new ResponseDTO("Created Successfully", emp);
    }

    @PutMapping("/{id}")
    public ResponseDTO update(@PathVariable int id, @Valid @RequestBody EmployeeDTO dto) {
        Employee emp = service.update(id, dto);
        return new ResponseDTO("Updated Successfully", emp);
    }

    @DeleteMapping("/{id}")
    public ResponseDTO delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseDTO("Deleted Successfully", null);
    }
}